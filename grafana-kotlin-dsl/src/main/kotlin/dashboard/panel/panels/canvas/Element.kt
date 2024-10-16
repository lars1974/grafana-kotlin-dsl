package dashboard.panel.panels.canvas

import AbstractGrafanaObject
import dashboard.panel.common.Links

class Element : AbstractGrafanaObject() {
    fun name(name: String) = field("name", name)
    fun type(type: Type) = field("type", type.value)
    fun background(background: Background.() -> Unit) = obj("background", Background().apply(background))
    fun border(border: Border.() -> Unit) = obj("border", Border().apply(border))
    fun config(config: Config.() -> Unit) = obj("config", Config().apply(config))
    fun constraint(constraint: Constraint.() -> Unit) = obj("constraint", Constraint().apply(constraint))
    fun links(links: Links.() -> Unit) = array("links", Links().apply(links))


    fun placement(horizontal: Placement.HorizontalConstraint, vertical: Placement.VerticalConstraint, rotation: Int = 0) {
        placement {
            rotation(rotation)
            when (horizontal) {
                is Placement.LeftRight -> left(horizontal.left).also { right(horizontal.right) }
                is Placement.LeftWidth -> left(horizontal.left).also { width(horizontal.width) }
                is Placement.CenterHorizontal -> left(horizontal.left).also { width(horizontal.width) }
                is Placement.RightWidth -> right(horizontal.right).also { width(horizontal.width) }
            }
            when (vertical) {
                is Placement.TopBottom -> top(vertical.top).also { bottom(vertical.bottom) }
                is Placement.TopHeight -> top(vertical.top).also { height(vertical.height) }
                is Placement.CenterVertical -> top(vertical.top).also { height(vertical.height) }
                is Placement.BottomHeight -> bottom(vertical.bottom).also { height(vertical.height) }
            }
        }
        constraint {
            horizontal(horizontal.horizontal)
            vertical(vertical.vertical)
        }


    }

    fun placement(placement: Placement.() -> Unit) = obj("placement", Placement().apply(placement))

    enum class Type(val value: String) {
        MetricValue("metric-value"),
    }

}