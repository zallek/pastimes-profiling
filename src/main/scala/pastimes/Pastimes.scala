package pastimes

import java.io._
import java.nio.file.Paths

import org.apache.spark.sql._
import org.apache.spark.sql.types._
import play.api.libs.json._


/** Main class */
object Pastimes {

  import org.apache.spark.sql.SparkSession
  import org.apache.spark.sql.functions._

  val spark: SparkSession =
    SparkSession
      .builder()
      .appName("Pastimes Profiling")
      .config("spark.master", "local")
      .getOrCreate()

  // For implicit conversions like converting RDDs to DataFrames
  import spark.implicits._

  /** Main function */
  def main(args: Array[String]): Unit = {
    val codesDf = activityCodes()
    codesDf.show()
  }

  def resourcePath(resource: String): String =
    Paths.get(getClass.getResource(resource).toURI).toString

  def activityCodes(): DataFrame = {
    val codeSchema = StructType(Array(
      StructField("code", IntegerType, nullable = false),
      StructField("name", StringType, nullable = false)))

    val df = spark.read
      .format("com.databricks.spark.csv")
      .option("header", "true") // Use first line of all files as header
      .schema(codeSchema)
      .load(resourcePath("/pastimes/codes.csv"))

    val groupColumn: Column =
      $"code"
        .cast(StringType)
        .substr(0, 2)
        .cast(IntegerType)
        .as("group")

    val subGroupColumn: Column =
      $"code"
        .cast(StringType)
        .substr(0, 4)
        .cast(IntegerType)
        .as("subGroup")

    df
      .select($"code", groupColumn, subGroupColumn, $"name")
      .where(groupColumn.between(12, 14))
      .orderBy($"code")
  }

}