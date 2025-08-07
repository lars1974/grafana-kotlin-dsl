package dashboard.panel.panels.bargauge

import AbstractGrafanaObject
import dashboard.panel.common.options.Options
import dashboard.panel.common.options.legend.LegendSupport
import dashboard.panel.common.options.reduceoptions.ReduceOptionsSupport
import dashboard.panel.common.options.tooltip.TooltipSupport
import dashboard.panel.panels.gauge.GaugeOptions

class BargaugeOptions: AbstractGrafanaObject(), TooltipSupport, LegendSupport, ReduceOptionsSupport {

    fun orientation(orientation: Orientation) = field("orientation", orientation.value)
    fun displayMode(displayMode: DisplayMode) = field("displayMode", displayMode.value)
    fun valueMode(valueMode: ValueMode) = field("valueMode", valueMode.value)
    fun namePlacement(namePlacement: NamePlacement) = field("namePlacement", namePlacement.value)
    fun showUnfilled(showUnfilled: Boolean) = field("showUnfilled", showUnfilled)
    fun sizing(sizing: Sizing) = field("sizing", sizing.value)
    fun minVizWidth(minVizWidth: Int) = field("minVizWidth", minVizWidth)
    fun minVizHeight(minVizHeight: Int) = field("minVizHeight", minVizHeight)
    fun maxVizHeight(maxVizHeight: Int) = field("maxVizHeight", maxVizHeight)


    enum class Sizing(val value: String) {
        Auto("auto"),
    }

    enum class NamePlacement(val value: String) {
        Auto("auto"),
    }

    enum class ValueMode(val value: String) {
        Value("value"),
        Percentage("percentage"),
        Color("color")
    }

    enum class DisplayMode(val value: String) {
        NoFill("nofill"),
        Fill("fill"),
        Gradient("gradient")
    }

    enum class Orientation(val value: String) {
        Vertical("vertical"),
        Horizontal("horizontal")
    }




}