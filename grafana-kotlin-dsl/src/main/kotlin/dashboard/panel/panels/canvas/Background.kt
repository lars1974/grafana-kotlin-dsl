package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Background : AbstractGrafanaObject() {
    fun color(color: Color.() -> Unit) = obj("color", Color().apply(color))
    fun image(image: Image.() -> Unit) = obj("image", Image().apply(image))
    fun size(size: String) = field("size", size)


}