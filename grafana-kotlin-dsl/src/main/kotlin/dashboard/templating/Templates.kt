package dashboard.templating

import AbstractGrafanaArray
import dashboard.templating.templates.ConstantTemplate
import dashboard.templating.templates.CustomTemplate
import dashboard.templating.templates.PrometheusTemplate
import dashboard.templating.templates.TextboxTemplate

class Templates: AbstractGrafanaArray() {
    fun custom(name: String, custom: CustomTemplate.() -> Unit) = add( CustomTemplate(name).apply(custom))
    fun prometheus(name: String, prometheus: PrometheusTemplate.() -> Unit) = add( PrometheusTemplate(name).apply(prometheus))
    fun textbox(name: String, textbox: TextboxTemplate.() -> Unit) = add( TextboxTemplate(name).apply(textbox))
    fun constant(name: String, constant: ConstantTemplate.() -> Unit) = add( ConstantTemplate(name).apply(constant))
}