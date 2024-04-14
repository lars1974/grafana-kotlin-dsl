package dashboard.panel.panels.text

import AbstractGrafanaObject

class TextOptions: AbstractGrafanaObject() {

    fun mode(mode: Mode) = field("mode", mode.value)
    fun code(code: Code.() -> Unit) = obj("code", Code().apply(code))
    fun content(content: String) = field("content", content)

    enum class Mode(val value: String){
        PlainText("plaintext"),
        MarkDown("markdown")
    }

}