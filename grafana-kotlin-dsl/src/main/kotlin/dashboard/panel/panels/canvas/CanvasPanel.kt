package dashboard.panel.panels.canvas

import dashboard.panel.Panel


class CanvasPanel : Panel(){
    init {
        type("canvas")
    }

    fun options(options: CanvasOptions.() -> Unit) = obj("options", CanvasOptions().apply(options))




}