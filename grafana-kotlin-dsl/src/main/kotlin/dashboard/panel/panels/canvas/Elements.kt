package dashboard.panel.panels.canvas

import AbstractGrafanaArray

class Elements :  AbstractGrafanaArray() {
    fun element(element: Element.() -> Unit) = add(Element().apply(element))
}