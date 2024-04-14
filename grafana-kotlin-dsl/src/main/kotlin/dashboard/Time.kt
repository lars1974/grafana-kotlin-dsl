package dashboard

import AbstractGrafanaObject

class Time(): AbstractGrafanaObject() {
    constructor(from: String, to: String): this(){
        from(from)
        to(to)
    }

    constructor(predifinedInterval: TimeIntervalEnum): this(){
        from(predifinedInterval.from)
        to(predifinedInterval.to)
    }

    fun from(from: String) = field("from", from)
    fun to(to: String) = field("to", to)

    enum class TimeIntervalEnum(val from: String, val to: String){
        Last5Minutes("now-5m", "now"),
        Last15Minutes("now-15m", "now"),
        Last30Minutes("now-30m", "now"),
        Last1Hour("now-1h", "now"),
        Last3Hours("now-3h", "now"),
        Last6Hours("now-6h", "now"),
        Last12Hours("now-12h", "now"),
        Last24Hours("now-24h", "now"),
        Last2Days("now-2d", "now"),
        Last7Days("now-7d", "now"),
        Last30Days("now-30d", "now"),
        Last90Days("now-90d", "now"),
        Last6Months("now-6M", "now"),
        Last1Year("now-1y", "now"),
        Last2Years("now-2y", "now"),
        Last5Years("now-5y", "now"),
        Yesterday("now-1d/d", "now-1d/d"),
        DayBeforeYesterday("now-2d/d", "now-2d/d"),
        ThisDayLastWeek("now-7d/d", "now-7d/d"),
        PreviousWeek("now-1w/w", "now-1w/w"),
        PreviousMonth("now-1M/M", "now-1M/M"),
        PreviousFiscalQuarter("now-1q/q", "now-1q/q"),
        PreviousYear("now-1y/y", "now-1y/y"),
        PreviousFiscalYear("now-1y/y", "now-1y/y"),
        Today("now/d", "now/d"),
        TodaySoFar("now/d", "now"),
        ThisWeek("now/w", "now/w"),
        ThisWeekSoFar("now/w", "now"),
        ThisMonth("now/M", "now/M"),
        ThisMonthSoFar("now/M", "now"),
        ThisFiscalQuarterSoFar("now/q", "now"),
        ThisFiscalQuarter("now/q", "now/q"),
        ThisFiscalYearSoFar("now/y", "now"),
        ThisFiscalYear("now/y", "now/y")


    }
}