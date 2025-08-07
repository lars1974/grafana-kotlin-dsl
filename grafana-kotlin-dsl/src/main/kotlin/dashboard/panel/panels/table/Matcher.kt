package dashboard.panel.panels.table

import AbstractGrafanaObject

class Matcher() : AbstractGrafanaObject() {
    constructor(id: String, options: String) : this() {
        id(id)
        options(options)
    }

    fun id(id: String) = field("id", id)
    fun options(options: String) = field("options", options)



}