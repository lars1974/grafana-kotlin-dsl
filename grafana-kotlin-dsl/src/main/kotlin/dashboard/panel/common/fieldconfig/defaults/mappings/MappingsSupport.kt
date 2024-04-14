package dashboard.panel.common.fieldconfig.defaults.mappings

import JacksonSupport

/**
 * https://grafana.com/docs/grafana/latest/panels-visualizations/configure-value-mappings/
 *
 * implemented at *Defaults level
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
interface MappingsSupport: JacksonSupport {
    fun mappings(mappings: Mappings.() -> Unit) = array("mappings", Mappings().apply(mappings))
}