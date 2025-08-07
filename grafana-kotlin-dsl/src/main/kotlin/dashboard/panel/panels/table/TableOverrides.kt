package dashboard.panel.panels.table

import AbstractGrafanaArray

class TableOverrides : AbstractGrafanaArray()   {
    fun override(override: TableOverride.() -> Unit) = add(TableOverride().apply(override))

    fun overrideByName(name: String, properties: Properties.() -> Unit) {
       override {
           matchByName(name)
           properties {
               apply(properties)
           }
       }
    }
}