package dashboard.panel.panels.timeseries

import AbstractGrafanaObject

class LineStyle(): AbstractGrafanaObject() {
    constructor(fill: Fill, pattern: List<Int>) : this() {
        fill(fill)
        pattern(pattern)
    }

    fun pattern(pattern: List<Int>) = arrayOfInts("dash", pattern.toTypedArray())

    fun fill(fill: Fill) = field("fill", fill.value)

    enum class Fill(val value: String){
        Solid("solid"),
        Dots("dots"),
        Dash("dach")
    }
}