package dashboard.panel.panels.table

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class TableFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: TableDefaults.() -> Unit) = obj("defaults", TableDefaults().apply(defaults))

    fun overrides(overrides: TableOverrides.() -> Unit) = array("overrides", TableOverrides().apply(overrides))
}