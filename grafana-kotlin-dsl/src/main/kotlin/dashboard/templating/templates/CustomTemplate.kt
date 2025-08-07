package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template

class CustomTemplate(name: String): Template(name) {
    init {
        type("custom")
        current()
    }
    constructor(name: String, selected: String, vararg options: String): this(name) {
        query(options.joinToString(","))
        options {
            options.forEach {
                option(it, it, it == selected)
            }
        }

    }

    fun query(query: String) = field("query", query)
    fun options(options: CustomOptions.() -> Unit) = array("options", CustomOptions().apply(options))
    fun current() = obj("current", AbstractGrafanaObject())


}