package dashboard.panel.target.targets.infinity

import AbstractGrafanaArray

class Params: AbstractGrafanaArray() {
    fun param(param: Param.() -> Unit) = add(Param().apply(param))
    fun param(key: String, value: String) = add(Param().apply { key(key); value(value) })
}