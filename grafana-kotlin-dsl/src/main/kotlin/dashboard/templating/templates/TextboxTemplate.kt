package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template

class TextboxTemplate(name: String): Template(name) {
    init {
        type("textbox")
        current()
    }

    fun current() = obj("current", AbstractGrafanaObject())
}