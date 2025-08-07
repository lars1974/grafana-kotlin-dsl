package dashboard.panel.panels.table

import AbstractGrafanaObject
import dashboard.panel.common.Calcs

class Footer : AbstractGrafanaObject() {
    fun show(show: Boolean) = field("show", show)
    fun reducer(vararg reducers: String) = arrayOfStrings("reducer", reducers.map { it }.toTypedArray())
    fun fields(vararg fields: String) = arrayOfStrings("fields", fields.map { it }.toTypedArray())

    fun countRows(countRows: Boolean) = field("countRows", countRows)



}