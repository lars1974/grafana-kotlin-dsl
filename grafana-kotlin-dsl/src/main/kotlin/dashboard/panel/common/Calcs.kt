package dashboard.panel.common

enum class Calcs(val value: String){
        LastNotNull("lastNotNull"),
        Last("last"),
        FirstNotNull("firstNotNull"),
        First("firstN"),
        Min("min"),
        Max("max"),
        Mean("mean"),
        Variance("variance"),
        StdDev("stdDev"),
        Sum("sum"),
        Count("count"),
        Range("range"),
        Delta("delta"),
        Step("step"),
        Diff("diff"),
        Logmin("logmin"),
        AllIsZero("allIsZero"),
        AllIsNull("allIsNull"),
        ChangeCount("changeCount"),
        DistinctCount("distinctCount"),
        Diffperc("diffperc"),
        AllValues("allValues"),
        UniqueValues("uniqueValues")


    }