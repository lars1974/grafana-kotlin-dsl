package dashboard.panel.panels.stat

import AbstractGrafanaObject
import dashboard.panel.common.options.reduceoptions.ReduceOptionsSupport

class StatOptions: AbstractGrafanaObject(), ReduceOptionsSupport {

    fun orientation(orientation: Orientation) = field("orientation", orientation.value)
    fun textMode(textMode: TextMode) = field("textMode", textMode.value)
    fun wideLayout(wideLayout: Boolean) = field("wideLayout", wideLayout)
    fun colorMode(colorMode: ColorMode) = field("colorMode", colorMode.value)
    fun graphMode(graphMode: GraphMode) = field("graphMode", graphMode.value)
    fun justifyMode(justifyMode: JustifyMode) = field("justifyMode", justifyMode.value)
    fun showPercentChange(showPercentChange: Boolean) = field("showPercentChange", showPercentChange)

    enum class JustifyMode(val value: String){
        Auto("auto"),
        Center("center")
    }

    enum class Orientation(val value: String){
        Auto("auto"),
        Horizontal("horizontal"),
        Vertical("vertical")
    }

    enum class GraphMode(val value: String){
        Area("area"),
        None("none")
    }

    enum class TextMode(val value: String){
        ValueAndName("value_and_name"),
        Auto("auto"),
        Value("value"),
        Name("name"),
        None("none")
    }

    enum class ColorMode(val value: String){
        None("none"),
        Value("value"),
        Background("background"),
        BackgroundSolid("background_solid")
    }
}