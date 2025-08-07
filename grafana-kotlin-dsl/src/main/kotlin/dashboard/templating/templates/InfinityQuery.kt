package dashboard.templating.templates

import dashboard.panel.target.targets.infinity.Columns
import dashboard.panel.target.targets.infinity.InfinityTarget


class InfinityQuery : InfinityTarget() {
    init {
        refId("")
    }



    fun columnsValueText(textSelector: String, valueSelector: String) {
        array("columns", Columns().apply {
            column {
                selector(textSelector)
                text("__text")
                type("string")
            }
            column {
                selector(valueSelector)
                text("__value")
                type("string")
            }
        })
    }




}
