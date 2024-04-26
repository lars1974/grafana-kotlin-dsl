package dashboard.panel.common.options

import AbstractGrafanaObject

class Text: AbstractGrafanaObject() {
    fun titleSize(size: Int) = field("titleSize", size)
    fun valueSize(size: Int) = field("valueSize", size)
}