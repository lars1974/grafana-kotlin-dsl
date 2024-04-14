package dashboard.panel.panels.gauge

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class GaugeFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: dashboard.panel.panels.gauge.GaugeDefaults.() -> Unit) = obj("defaults", dashboard.panel.panels.gauge.GaugeDefaults().apply(defaults))
}