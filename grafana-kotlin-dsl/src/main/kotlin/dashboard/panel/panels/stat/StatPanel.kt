package dashboard.panel.panels.stat

import dashboard.panel.Panel


class StatPanel: Panel() {
    init {
        type("stat")
    }
    fun options(options: StatOptions.() -> Unit) = obj("options", StatOptions().apply(options))

    fun fieldConfig(fieldConfig: StatFieldConfig.() -> Unit) = obj("fieldConfig", StatFieldConfig().apply(fieldConfig))

}