package dashboard.panel.panels.timeseries

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport


class TimeseriesFieldConfig: AbstractGrafanaObject(), StandardOptionsSupport {
    fun defaults(defaults: TimeseriesDefaults.() -> Unit) = obj("defaults", TimeseriesDefaults().apply(defaults))
}