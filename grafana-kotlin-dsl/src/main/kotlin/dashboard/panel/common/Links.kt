package dashboard.panel.common

import AbstractGrafanaArray

class Links: AbstractGrafanaArray() {
    fun link(title: String, url: String, targetBlank: Boolean) = add(Link(title, url, targetBlank))
}