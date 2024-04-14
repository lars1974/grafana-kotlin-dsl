package dashboard.panel.panels.stat

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class StatFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: StatDefaults.() -> Unit) = obj("defaults", StatDefaults().apply(defaults))
}