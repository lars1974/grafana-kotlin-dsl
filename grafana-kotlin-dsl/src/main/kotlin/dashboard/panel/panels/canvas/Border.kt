package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Border : AbstractGrafanaObject() {
    fun color(color: Color.() -> Unit) = obj("color", Color().apply(color))
    fun width(width: Int) = field("width", width)
    fun radius(radius: Int) = field("radius", radius)


}
