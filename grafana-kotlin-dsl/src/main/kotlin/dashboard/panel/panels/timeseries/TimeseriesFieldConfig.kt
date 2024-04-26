package dashboard.panel.panels.timeseries

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport
import dashboard.panel.common.fieldconfig.defaults.color.ColorSupport


class TimeseriesFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: TimeseriesDefaults.() -> Unit) = obj("defaults", TimeseriesDefaults().apply(defaults))
}