package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Config : AbstractGrafanaObject() {

    fun color(color: Color.() -> Unit) = obj("color", Color().apply(color))
    fun size(size: Int) = field("size", size)
    fun text(text: Text.() -> Unit) = obj("text", Text().apply(text))
    fun vAlign(vAlign: VAlign) = field("valign", vAlign.value)
    fun align(align: Align) = field("align", align.value)


    enum class VAlign(val value: String) {
        Top("top"),
    }


    enum class Align(val value: String) {
        Left("left"),
        Right("right"),

    }

}
