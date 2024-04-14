package dashboard.panel.panels.timeseries

import AbstractGrafanaObject

class Stacking(): AbstractGrafanaObject() {
    constructor(mode: String, group: String): this(){
        mode(mode)
        group(group)
    }

    fun mode(mode: String) = field("mode", mode)
    fun group(group: String) = field("group", group)
}