package dashboard.panel.common.fieldconfig.defaults.color

import AbstractGrafanaObject

class Color(): AbstractGrafanaObject() {
    constructor(mode: Mode): this(){
        mode(mode)
    }

    fun fixedColor(fixedColor: String) = field("fixedColor", fixedColor)
    fun mode(mode: Mode) = field("mode", mode.value)

    enum class Mode(val value: String) {
        Single("fixed"),
        Shades("shades"),
        Thresholds("thresholds"),
        PaletteClassic("palette-classic"),
        PaletteClassicByName("palette-classic-by-name"),
        ContinuousReds("continuous-reds")
    }
}

