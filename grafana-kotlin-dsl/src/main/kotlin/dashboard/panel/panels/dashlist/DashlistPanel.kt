package dashboard.panel.panels.dashlist

import dashboard.panel.Panel
import dashboard.panel.panels.text.TextOptions

class DashlistPanel : Panel() {
    init {
        type("dashlist")
    }



    fun options(options: DashlistOptions.() -> Unit) = obj("options", DashlistOptions().apply(options))

}


