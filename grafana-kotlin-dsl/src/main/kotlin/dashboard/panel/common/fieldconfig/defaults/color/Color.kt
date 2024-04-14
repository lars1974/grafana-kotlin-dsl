package dashboard.panel.common.fieldconfig.defaults.color

import AbstractGrafanaObject

class Color(): AbstractGrafanaObject() {
    constructor(mode: Mode): this(){
        mode(mode)
    }
    fun mode(mode: Mode) = field("mode", mode.value)

    enum class Mode(val value: String) {
        PaletteClassic("palette-classic"),
        Thresholds("thresholds")
    }
}

