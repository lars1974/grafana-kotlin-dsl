package dashboard.panel.panels.bargauge

import dashboard.panel.Panel

class BargaugePanel: Panel() {
    init {
        type("bargauge")
    }

    fun options(piechartOptions: BargaugeOptions.() -> Unit) = obj("options", BargaugeOptions().apply(piechartOptions))

    fun fieldConfig(fieldConfig: BargaugeFieldConfig.() -> Unit) = obj("fieldConfig", BargaugeFieldConfig().apply(fieldConfig))
}