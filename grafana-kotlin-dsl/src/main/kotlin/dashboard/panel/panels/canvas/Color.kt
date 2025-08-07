package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Color : AbstractGrafanaObject() {
    fun fixed(color: String) = field("fixed", color)
    fun field(field: String) = field("field", field)
}