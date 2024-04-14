package dashboard.panel.panels.timeseries

import dashboard.panel.Panel


class TimeseriesPanel(): Panel() {
    init {
        type("timeseries")
    }

    constructor(title: String): this() {
        title(title)
    }

    fun options(timeseriesOptions: TimeseriesOptions.() -> Unit) = obj("options", TimeseriesOptions().apply(timeseriesOptions))

    fun fieldConfig(fieldConfig: TimeseriesFieldConfig.() -> Unit) = obj("fieldConfig", TimeseriesFieldConfig().apply(fieldConfig))

}