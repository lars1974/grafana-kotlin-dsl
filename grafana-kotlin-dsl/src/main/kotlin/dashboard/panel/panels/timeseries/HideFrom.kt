package dashboard.panel.panels.timeseries

import AbstractGrafanaObject

class HideFrom: AbstractGrafanaObject() {
    fun tooltip(tooltip: Boolean) = field("tooltip", tooltip)
    fun legend(legend: Boolean) = field("legend", legend)
    fun viz(viz: Boolean) = field("viz", viz)
}