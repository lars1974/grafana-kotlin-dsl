package dashboard.panel.common.options.legend

import AbstractGrafanaObject
import dashboard.panel.common.Calcs

class Legend: AbstractGrafanaObject() {
    fun showLegend(showLegend: Boolean) = field("showLegend", showLegend)
    fun displayMode(displayMode: DisplayMode) = field("displayMode", displayMode.value)
    fun placement(placement: Placement) = field("placement", placement.value)
    fun calcs(vararg calcs: Calcs) = arrayOfStrings("calcs", calcs.map { it.value }.toTypedArray())

    enum class DisplayMode(val value: String){
        List("list"),
        Table("table")
    }
    enum class Placement(val value: String){
        Right("right"),
        Bottom("bottom")
    }
}