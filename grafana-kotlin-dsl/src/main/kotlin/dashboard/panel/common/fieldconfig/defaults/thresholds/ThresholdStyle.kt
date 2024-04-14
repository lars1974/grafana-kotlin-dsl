package dashboard.panel.common.fieldconfig.defaults.thresholds

import AbstractGrafanaObject

class ThresholdStyle(): AbstractGrafanaObject() {
    constructor(mode: Mode): this(){
        mode(mode)
    }

    fun mode(mode: Mode) = field("mode", mode.value)

    enum class Mode(val value: String){
        Off("off"),
        Line("line"),
        Dashed("dashed"),
        Area("area"),
        LinePlusArea("line+area"),
        DashedPlusArea("dashed+area")
    }
}