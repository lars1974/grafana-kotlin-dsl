package dashboard.panel.target.transformations

import AbstractGrafanaObject

class FilterByName() : AbstractGrafanaObject()     {
    constructor(vararg names: String) : this() {
       options {
                include(*names)

            }

    }

    init {
        field("id", "filterFieldsByName")
    }

    fun options(options: FilterByNameOptions.() -> Unit) = obj("options", FilterByNameOptions().apply(options))


}