package dashboard.panel.target.transformations

import AbstractGrafanaObject

class FilterByNameOptions : AbstractGrafanaObject() {
    fun include(vararg names: String){
        obj("include", AbstractGrafanaObject().apply {
            arrayOfStrings("names", names.toList().toTypedArray())
        })
    }
}