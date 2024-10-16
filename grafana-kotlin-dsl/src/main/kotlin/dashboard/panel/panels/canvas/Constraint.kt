package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Constraint : AbstractGrafanaObject() {
    fun horizontal(horizontal: Horizontal) = field("horizontal", horizontal.value)
    fun vertical(vertical: Vertical) = field("vertical", vertical.value)




    enum class Horizontal(val value: String) {
        LeftRight("leftright"),
        LeftWidth("left"),
        RightWidth("right"),
        CenterWidth("center"),
    }

    enum class Vertical(val value: String) {
        TopBottom("top"),
        TopHeight("top"),
        BottomHeight("bottom"),
        CenterHeight("center"),
    }
}