Identify American's profile doing leisure activities, sports, volunteering, religious activites and more.

Provide an interactive infographic.


# Features

Age: TEAGE
Sex: TESEX
Race: PTDTRACE and PEHSPNON

USA State Code: CPS.GESTFIPS
USA Region: CPS.GEREG
Metropolitan status: CPS.GEMETSA or CPS.GTMETSTA

Employment status: TELFS and TRDPFTPT and TESCHENR
Occupation category: RESP.TRDTOCC1
Presence of the respondent's spouse or unmarried partner in the
household: TRSPPRES
Employment status of spouse or unmarried partner: TESPEMPNOT and TRSPFTPT
Income: CPS.HUFAMINC or CPS.HEFAMINC

Number of household children < 18: TRCHILDNUM
Age of youngest household child < 18: TRYHHCHILD

Highest level of school: PEEDUCA

**Weight:** TUFNWGTP


# Output format

Map<ActivityCode, [Profile]>

Activity: Int
Profile: {
    age: [Int, Int],
    married: Boolean,
    children: [Int, Int],
}