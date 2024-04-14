package dashboard.panel.common.fieldconfig

import JacksonSupport


/**
 * https://grafana.com/docs/grafana/latest/panels-visualizations/configure-standard-options/
 *
 * Bar chart
 * Geomap
 * Status history
 * Bar gauge
 * Histogram
 * Table
 * Candlestick
 * Pie chart
 * Time series
 * Canvas
 * Stat
 * Trend
 * Gauge
 * State timeline
 */
interface StandardOptionsSupport: JacksonSupport {
    fun fieldMinMax(fieldMinMax: Boolean) = field("fieldMinMax", fieldMinMax)
    fun decimals(decimals: Int) = field("decimals", decimals)
    fun displayName(displayName: String) = field("displayName", displayName)
    fun noValue(noValue: Int) = field("noValue", noValue)
    fun min(min: Int) = field("min", min)
    fun max(max: Int) = field("max", max)


    fun unit(unit: Unit) = field("unit", unit.value)

    enum class Unit(val value: String){
        Number("none"),
        StringUnit("string"),
        Short("short"),
        Percent("percent"),
        PercentUnit("percentunit"),

        AccG("accG")
    }
}