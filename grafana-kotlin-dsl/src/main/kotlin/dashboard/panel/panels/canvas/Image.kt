package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Image : AbstractGrafanaObject() {
    fun mode(mode: String) = field("mode", mode)
}