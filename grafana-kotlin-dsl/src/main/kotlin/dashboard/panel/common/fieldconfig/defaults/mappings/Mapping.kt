package dashboard.panel.common.fieldconfig.defaults.mappings

import AbstractGrafanaObject

class Mapping: AbstractGrafanaObject() {
    fun options(color: Options.() -> Unit = {}){ obj("options", Options().apply(color)) }
    fun type(type: Type) = field("type", type.value)

    enum class Type(val value: String){
        Range("range"),
        Special("special")
    }

}