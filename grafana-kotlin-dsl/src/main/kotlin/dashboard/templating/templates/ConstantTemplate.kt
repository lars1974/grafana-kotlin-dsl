package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template

class ConstantTemplate(name: String): Template(name) {
    init {
        type("constant")
        current()
    }

    fun current() = obj("current", AbstractGrafanaObject())
    fun query(query: String) = field("query", query)
}