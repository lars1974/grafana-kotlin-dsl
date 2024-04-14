package dashboard.panel.common.options.tooltip

import JacksonSupport

/**
 * https://grafana.com/docs/grafana/latest/panels-visualizations/configure-tooltips/
 *
 * Bar chart
 * State timeline
 * Candlestick
 * Status history
 * Heatmap
 * Time series
 * Pie chart
 * Trend
 *
 *
 */

interface TooltipSupport: JacksonSupport {

    fun tooltip(tooltip: Tooltip.() -> Unit = {}) = obj("tooltip", Tooltip().apply(tooltip))

    fun tooltip(mode: String, sort: String, tooltip: Tooltip.() -> Unit = {}) = obj("tooltip", Tooltip(Tooltip.Mode.None, Tooltip.Sort.None).apply(tooltip))

}