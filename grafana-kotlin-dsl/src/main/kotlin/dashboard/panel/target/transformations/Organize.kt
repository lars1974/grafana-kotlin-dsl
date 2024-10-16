package dashboard.panel.target.transformations

import AbstractGrafanaObject

class Organize() : AbstractGrafanaObject()     {
    constructor(indexByName: List<String>, excludeByName: List<String>, renameByName: Map<String, String>) : this() {
       options {
                indexByName(*indexByName.toTypedArray())
                excludeByName(*excludeByName.toTypedArray())
                renameByName(renameByName)
            }

    }

    init {
        field("id", "organize")
    }

    fun options(options: OrganizeOptions.() -> Unit) = obj("options", OrganizeOptions().apply(options))
}