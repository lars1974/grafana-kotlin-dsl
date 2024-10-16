package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Root : AbstractGrafanaObject() {
    init {
        type("frame")
    }

    fun type(type: String) = field("type", type)
    fun elements(elements: Elements.() -> Unit) = array("elements", Elements().apply(elements))
    fun background(background: Background.() -> Unit) = obj("background", Background().apply(background))
    fun border(border: Border.() -> Unit) = obj("border", Border().apply(border))

}