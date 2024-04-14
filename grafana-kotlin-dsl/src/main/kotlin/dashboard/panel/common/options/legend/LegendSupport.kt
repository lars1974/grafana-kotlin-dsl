package dashboard.panel.common.options.legend

import JacksonSupport

/**
 * https://grafana.com/docs/grafana/latest/panels-visualizations/configure-legend/
 *
 * Bar chart
 * Candlestick
 * Histogram
 * Pie chart
 * State timeline
 * Status history
 * Time series
 * Trend
 */
interface LegendSupport: JacksonSupport {
    fun legend(legend: Legend.() -> Unit) = obj("legend", Legend().apply(legend))
}