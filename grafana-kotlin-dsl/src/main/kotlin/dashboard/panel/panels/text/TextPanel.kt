package dashboard.panel.panels.text

import dashboard.panel.Panel


class TextPanel: Panel() {
    init {
        type("text")
    }

    fun options(options: TextOptions.() -> Unit) = obj("options", TextOptions().apply(options))
}