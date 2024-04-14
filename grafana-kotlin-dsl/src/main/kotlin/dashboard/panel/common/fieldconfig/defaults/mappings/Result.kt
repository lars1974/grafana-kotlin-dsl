package dashboard.panel.common.fieldconfig.defaults.mappings

import AbstractGrafanaObject

class Result: AbstractGrafanaObject() {
    fun index(index: Int) = field("index", index)
    fun text(text: String) = field("text", text)
}