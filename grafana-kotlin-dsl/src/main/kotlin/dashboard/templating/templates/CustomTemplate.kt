package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template

class CustomTemplate(name: String): Template(name) {
    init {
        type("custom")
        current()
    }
    fun options(options: CustomOptions.() -> Unit) = array("options", CustomOptions().apply(options))
    fun current() = obj("current", AbstractGrafanaObject())
}