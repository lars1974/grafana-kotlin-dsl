package dashboard.panel.common.fieldconfig.defaults.thresholds

import JacksonSupport

/**
 * Implemented at *Default level
 * https://grafana.com/docs/grafana/latest/panels-visualizations/configure-thresholds/
 *
 * Bar chart
 * Geomap
 * Status history
 * Bar gauge
 * Histogram
 * Table
 * Candlestick
 * Stat
 * Time series
 * Canvas
 * State timeline
 * Trend
 * Gauge
 */

interface ThresholdSupport: JacksonSupport {
    fun thresholds(threshold: Thresholds.() -> Unit){ obj("thresholds", Thresholds().apply(threshold)) }

    fun thresholds(mode: Thresholds.Mode, values: List<Double?>, colors: List<String>, threshold: Thresholds.() -> Unit = {}){
        val t = Thresholds()
        t.mode(mode)
        t.steps { 
            values.forEachIndexed { index, value ->
                add(colors[index], value)
            }
        }
        obj("thresholds", t)
    }
}