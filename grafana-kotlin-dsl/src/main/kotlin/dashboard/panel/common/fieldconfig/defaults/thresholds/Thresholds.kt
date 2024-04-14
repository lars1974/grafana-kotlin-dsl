package dashboard.panel.common.fieldconfig.defaults.thresholds

import AbstractGrafanaObject

class Thresholds : AbstractGrafanaObject() {
    fun mode(mode: Mode) = field("mode", mode.value)
    fun steps(steps: Steps.() -> Unit) {
        array("steps", Steps().apply(steps))

    }

    enum class Mode(val value: String){
        Absolute("absolute"),
        Percentage("percentage")
    }





}
