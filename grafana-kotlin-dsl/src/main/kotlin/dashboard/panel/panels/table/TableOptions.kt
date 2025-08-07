package dashboard.panel.panels.table

import AbstractGrafanaObject
import dashboard.panel.common.options.reduceoptions.ReduceOptionsSupport

class TableOptions: AbstractGrafanaObject(), ReduceOptionsSupport {
    fun showHeader(showHeader: Boolean) = field("showHeader", showHeader)
    fun cellHeight(cellHeight: CellHeight) = field("cellHeight", cellHeight.value)
    fun footer(footer: Footer.() -> Unit) = obj("footer", Footer().apply(footer))
    //fun angular(angular: Angular.() -> Unit) = obj("angular", Angular().apply(angular))



    enum class CellHeight(val value: String) {
        Small("sm"),
        Medium("md"),
        Large("lg"),
    }



}



