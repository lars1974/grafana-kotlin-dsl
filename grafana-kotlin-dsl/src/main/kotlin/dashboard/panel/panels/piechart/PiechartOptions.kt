package dashboard.panel.panels.piechart

import AbstractGrafanaObject
import dashboard.panel.common.options.legend.LegendSupport
import dashboard.panel.common.options.tooltip.TooltipSupport

class PiechartOptions: AbstractGrafanaObject(), TooltipSupport, LegendSupport {
    fun pieType(pieType: PieType) = field("pieType", pieType.value)

    fun displayLabels(vararg displayLabels: DisplayLabel) = arrayOfStrings("displayLabels",displayLabels.map { it.value }.toTypedArray())

    enum class DisplayLabel(val value: String) {
        Name("name"),
        Value("value"),
        Percent("percent")
    }

    enum class PieType(val value: String) {
        Pie("pie"),
        Donut("donut")
    }
}