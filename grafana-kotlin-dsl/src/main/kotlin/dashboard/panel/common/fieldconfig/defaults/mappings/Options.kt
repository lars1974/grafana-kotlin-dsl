package dashboard.panel.common.fieldconfig.defaults.mappings

import AbstractGrafanaObject

class Options: AbstractGrafanaObject() {
    fun from(from: Double) = field("from", from)
    fun to(to: Double) = field("to", to)
    fun match(match: Match) = field("match", match.value)
    fun pattern(pattern: String) = field("pattern", pattern)
    fun result(result: Result.() -> Unit = {}) = obj("result", Result().apply(result))

    enum class Match(val value: String){
        NaN("NaN"),
        NullPlusNaN("null+nan"),
        True("true"),
        False("false"),
        Null("null"),
        Empty("empty")

    }

}