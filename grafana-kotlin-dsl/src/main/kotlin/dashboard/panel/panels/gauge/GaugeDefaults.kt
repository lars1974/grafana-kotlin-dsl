package dashboard.panel.panels.gauge


import JacksonSupport
import dashboard.panel.common.fieldconfig.StandardOptionsSupport
import dashboard.panel.common.fieldconfig.defaults.Defaults
import dashboard.panel.common.fieldconfig.defaults.mappings.MappingsSupport
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport

class GaugeDefaults: Defaults(), JacksonSupport, ThresholdSupport, MappingsSupport, StandardOptionsSupport