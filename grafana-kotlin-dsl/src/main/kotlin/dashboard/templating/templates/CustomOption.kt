package dashboard.templating.templates

import AbstractGrafanaObject

class CustomOption(): AbstractGrafanaObject() {
    constructor(text: String, value: String, selected: Boolean = false): this() {
        this.text(text)
        this.value(value)
        this.selected(selected)
    }

    fun selected(selected: Boolean)  = field("selected", selected)
    fun text(text: String) = field("text", text)
    fun value(value: String) = field("value", value)

}
