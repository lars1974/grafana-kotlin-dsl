package dashboard.panel.panels.gauge

import dashboard.panel.common.options.Options
import dashboard.panel.common.options.reduceoptions.ReduceOptionsSupport

class GaugeOptions: Options(), ReduceOptionsSupport {
    fun orientation(orientation: Orientation) = field("orientation", orientation.value)
    fun showThresholdLabels(showThresholdLabels: Boolean) = field("showThresholdLabels", showThresholdLabels)
    fun showThresholdMarkers(showThresholdMarkers: Boolean) = field("showThresholdMarkers", showThresholdMarkers)
    fun sizing(sizing: String) = field("sizing", sizing)
    fun minVizWidth(minVizWidth: Int) = field("minVizWidth", minVizWidth)
    fun minVizHeight(minVizHeight: Int) = field("minVizHeight", minVizHeight)

    enum class Orientation(val value: String){
        Horizontal("horizontal"),
        Vertical("vertical")
    }
}