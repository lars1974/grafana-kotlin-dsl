package dashboard.panel.panels.piechart

import dashboard.panel.Panel

class PiechartPanel: Panel() {
    init {
        type("piechart")
    }

    fun options(piechartOptions: PiechartOptions.() -> Unit) = obj("options", PiechartOptions().apply(piechartOptions))

    fun fieldConfig(fieldConfig: PiechartFieldConfig.() -> Unit) = obj("fieldConfig", PiechartFieldConfig().apply(fieldConfig))
}