package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class CanvasOptions : AbstractGrafanaObject() {
    fun inlineEditing(inlineEditing: Boolean) = field("inlineEditing", inlineEditing)
    fun showAdvancedTypes(showAdvancedTypes: Boolean) = field("showAdvancedTypes", showAdvancedTypes)
    fun panZoom(panZoom: Boolean) = field("panZoom", panZoom)
    fun infinitePan(infinitePan: Boolean) = field("infinitePan", infinitePan)
    fun root(root: Root.() -> Unit) = obj("root", Root().apply(root))
}

