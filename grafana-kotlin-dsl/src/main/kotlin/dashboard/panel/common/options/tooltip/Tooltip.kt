package dashboard.panel.common.options.tooltip

import AbstractGrafanaObject

class Tooltip(): AbstractGrafanaObject() {
    constructor(mode: Mode, sort: Sort): this(){
        mode(mode)
        sort(sort)
    }

    fun mode(mode: Mode) = field("mode", mode.value)
    fun sort(sort: Sort) = field("sort", sort.value)
    fun hoverProximity(hoverProximity: Int) = field("hoverProximity",hoverProximity)
    fun maxHeight(maxHeight: Int) = field("maxHeight",maxHeight)
    fun maxWidth(maxWidth: Int) = field("maxWidth",maxWidth)


    enum class Sort(val value: String){
        Asc("asc"),
        Desc("desc"),
        None("none")
    }

    enum class Mode(val value: String){
        Single("single"),
        Multi("multi"),
        None("none")
    }

}