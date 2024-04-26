package dashboard.panel.panels.timeseries


import JacksonSupport
import dashboard.panel.common.fieldconfig.defaults.Defaults
import dashboard.panel.common.fieldconfig.defaults.color.ColorSupport
import dashboard.panel.common.fieldconfig.defaults.mappings.MappingsSupport
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport

class TimeseriesDefaults: Defaults(), JacksonSupport, ThresholdSupport, MappingsSupport, ColorSupport {
    fun custom(custom: TimeseriesCustom.() -> Unit){ obj("custom", TimeseriesCustom().apply(custom)) }
}