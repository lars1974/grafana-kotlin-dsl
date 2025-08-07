package dashboard.panel.panels.bargauge

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport

class BargaugeFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: BargaugeDefaults.() -> Unit) = obj("defaults", BargaugeDefaults().apply(defaults))
}