package dashboard.panel.panels.gauge

import dashboard.panel.Panel

class GaugePanel: Panel() {
    init {
        type("gauge")
    }

    fun options(gaugeOptions: GaugeOptions.() -> Unit) = obj("options", GaugeOptions().apply(gaugeOptions))

    fun fieldConfig(fieldConfig: GaugeFieldConfig.() -> Unit) = obj("fieldConfig", GaugeFieldConfig().apply(fieldConfig))
}