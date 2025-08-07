package dashboard.panel.panels.gauge

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class GaugeFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: GaugeDefaults.() -> Unit) = obj("defaults", GaugeDefaults().apply(defaults))
}