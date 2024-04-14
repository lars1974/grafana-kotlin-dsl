package dashboard.panel.common.fieldconfig.defaults.thresholds

import AbstractGrafanaArray

class Steps: AbstractGrafanaArray() {
    fun add(step: Step.() -> Unit) = add(Step().apply(step))
    fun add(color: String, value: Double?, step: Step.() -> Unit = {}) = add(Step(color, value).apply(step))
}