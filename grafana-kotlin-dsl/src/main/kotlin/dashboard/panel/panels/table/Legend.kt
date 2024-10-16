package dashboard.panel.panels.table

import AbstractGrafanaObject

class Legend : AbstractGrafanaObject(){
    fun avg(avg: Boolean) = field("avg", avg)
    fun current(current: Boolean) = field("current", current)
    fun max(max: Boolean) = field("max", max)
    fun min(min: Boolean) = field("min", min)
    fun show(show: Boolean) = field("show", show)
    fun total(total: Boolean) = field("total", total)
    fun values(values: Boolean) = field("values", values)
}


