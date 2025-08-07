package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Text : AbstractGrafanaObject() {
    fun field(field: String) = field("field", field)
    fun fixed(fix: String) = field("fix", fix)
    fun mode(mode: Mode) = field("mode", mode.value)
    fun constraint(constraint: Constraint.() -> Unit) = obj("constraint", Constraint().apply(constraint))

    enum class Mode(val value: String) {
        Field("field"),
    }



}
