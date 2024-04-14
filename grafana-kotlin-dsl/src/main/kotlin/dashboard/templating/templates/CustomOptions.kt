package dashboard.templating.templates

import AbstractGrafanaArray

class CustomOptions: AbstractGrafanaArray() {
    fun option(option: CustomOption.() -> Unit) = add( CustomOption().apply(option))
    fun option(text: String, value: String) = add(CustomOption(text, value, false))


}