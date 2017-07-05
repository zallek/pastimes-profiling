name := "pastimes-profiling"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.10" % "test",
  "org.apache.spark" %% "spark-core" % "2.1.0",
  "org.apache.spark" %% "spark-sql" % "2.1.0",
  "com.databricks" %% "spark-csv" % "1.5.0",
  "com.typesafe.play" %% "play-json" % "2.6.0"
)