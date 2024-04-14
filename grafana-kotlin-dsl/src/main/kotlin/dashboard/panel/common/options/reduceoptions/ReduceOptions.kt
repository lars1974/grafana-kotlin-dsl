package dashboard.panel.common.options.reduceoptions

import AbstractGrafanaObject
import dashboard.panel.common.Calcs

class ReduceOptions: AbstractGrafanaObject() {
    fun values(values: Boolean) = field("values", values)
    fun calcs(vararg calcs: Calcs) = arrayOfStrings("calcs", calcs.map { it.value }.toTypedArray())
    fun fields(fields: String) = field("fields", fields)
    fun limit(limit: Int) = field("limit", limit)



}