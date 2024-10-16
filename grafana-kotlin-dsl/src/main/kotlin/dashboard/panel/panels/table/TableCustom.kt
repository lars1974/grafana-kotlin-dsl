package dashboard.panel.panels.table

import AbstractGrafanaObject

class TableCustom : AbstractGrafanaObject() {
    fun align(align: Align) = field("align", align.value)
    fun width(width: Int) = field("width", width)
    fun filterable(filterable: Boolean) = field("filterable", filterable)
    fun inspect(inspect: Boolean) = field("inspect", inspect)

    enum class Align(val value: String) {
        Auto("auto"),
        Left("left"),
        Center("center"),
        Right("right"),
    }

}