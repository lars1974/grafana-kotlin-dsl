package dashboard.panel.panels.table

import dashboard.panel.Panel
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdSupport
import dashboard.panel.panels.stat.StatFieldConfig
import dashboard.panel.panels.stat.StatOptions

class TablePanel() : Panel(), ThresholdSupport {
    init {
        type("table" +
                "")
    }

    constructor(title: String): this() {
        title(title)
    }

    fun options(options: TableOptions.() -> Unit) = obj("options", TableOptions().apply(options))

    fun fieldConfig(fieldConfig: TableFieldConfig.() -> Unit) = obj("fieldConfig", TableFieldConfig().apply(fieldConfig))

    }
