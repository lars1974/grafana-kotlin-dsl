package dashboard.templating

import AbstractGrafanaArray
import dashboard.panel.target.targets.infinity.InfinityTarget
import dashboard.templating.templates.*

class Templates: AbstractGrafanaArray() {
    fun custom(name: String, custom: CustomTemplate.() -> Unit) = add( CustomTemplate(name).apply(custom))
    fun custom(name: String, selected: String, vararg options: String, custom: CustomTemplate.() -> Unit) = add( CustomTemplate(name, selected, *options).apply(custom))

    fun prometheus(name: String, prometheus: PrometheusTemplate.() -> Unit) = add( PrometheusTemplate(name).apply(prometheus))
    fun infinity(name: String, infinity: InfinityTemplate.() -> Unit) = add(InfinityTemplate(name).apply(infinity))

    fun textbox(name: String, textbox: TextboxTemplate.() -> Unit) = add( TextboxTemplate(name).apply(textbox))
    fun constant(name: String, constant: ConstantTemplate.() -> Unit) = add( ConstantTemplate(name).apply(constant))
}