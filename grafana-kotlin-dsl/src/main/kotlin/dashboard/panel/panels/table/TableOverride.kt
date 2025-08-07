package dashboard.panel.panels.table


import AbstractGrafanaObject

class TableOverride : AbstractGrafanaObject()   {

    fun matchByName(name: String){
        obj("matcher", AbstractGrafanaObject().apply {
            field("id", "byName")
            field("options", name)
        })
    }
    fun id(id: String) = field("id", id)
    fun options(options: String) = field("options", options)
    fun properties(properties: Properties.() -> Unit) = array("properties", Properties().apply(properties))
}