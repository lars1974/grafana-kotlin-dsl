package dashboard.templating

import AbstractGrafanaObject

open class Template(name: String): AbstractGrafanaObject() {
    init {
        name(name)
    }


    fun skipUrlSync(skipUrlSync: Boolean) = field("skipUrlSync", skipUrlSync)
    fun hide(hide: Int) = field("hide", hide)
    fun includeAll(includeAll: Boolean) = field("includeAll", includeAll)
    fun multi(multi: Boolean) = field("multi", multi)
    fun name(name: String) = field("name", name)
    fun type(type: String) = field("type", type)


}