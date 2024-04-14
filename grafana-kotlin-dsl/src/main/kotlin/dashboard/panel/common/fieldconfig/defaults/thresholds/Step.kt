package dashboard.panel.common.fieldconfig.defaults.thresholds

import AbstractGrafanaObject

class Step(): AbstractGrafanaObject() {
    constructor(color: String, value: Double?) : this() {
        color(color)
        value(value)
    }

    fun color(color: String) = field("color", color)
    fun value(value: Double?) = field("value", value)
}