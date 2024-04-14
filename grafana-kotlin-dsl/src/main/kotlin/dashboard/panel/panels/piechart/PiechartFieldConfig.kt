package dashboard.panel.panels.piechart

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class PiechartFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: PiechartDefaults.() -> Unit) = obj("defaults", PiechartDefaults().apply(defaults))
}