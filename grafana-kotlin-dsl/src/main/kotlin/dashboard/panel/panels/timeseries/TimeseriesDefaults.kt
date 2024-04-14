package dashboard.panel.panels.timeseries


import JacksonSupport
import dashboard.panel.common.fieldconfig.defaults.Defaults
import dashboard.panel.common.fieldconfig.defaults.mappings.MappingsSupport
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport

class TimeseriesDefaults: Defaults(), JacksonSupport, ThresholdSupport, MappingsSupport {
    fun custom(custom: TimeseriesCustom.() -> Unit){ obj("custom", TimeseriesCustom().apply(custom)) }
}