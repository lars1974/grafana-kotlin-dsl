package dashboard.panel.panels.stat

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport
import dashboard.panel.common.fieldconfig.defaults.mappings.MappingsSupport
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport

class StatDefaults: AbstractGrafanaObject(), ThresholdSupport, StandardOptionsSupport, MappingsSupport