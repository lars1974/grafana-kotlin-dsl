package dashboard.panel.panels.table


import AbstractGrafanaObject
import JacksonSupport
import dashboard.panel.common.fieldconfig.defaults.Defaults
import dashboard.panel.common.fieldconfig.defaults.color.ColorSupport
import dashboard.panel.common.fieldconfig.defaults.mappings.MappingsSupport
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport

class TableDefaults: AbstractGrafanaObject(), JacksonSupport, ThresholdSupport, MappingsSupport, ColorSupport {
    fun custom(custom: TableCustom.() -> Unit) = obj("custom", TableCustom().apply(custom))


}