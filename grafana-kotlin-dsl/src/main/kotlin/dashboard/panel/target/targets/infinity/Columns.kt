package dashboard.panel.target.targets.infinity

import AbstractGrafanaArray

class Columns : AbstractGrafanaArray() {
    fun column(column: Column.() -> Unit) = add(Column().apply(column))
    fun columnTime(selector: String, text: String, timestampFormat: String = "yyyy-mm-dd") = column {
        selector(selector)
        text(text)
        timestampFormat(timestampFormat)
        type(Column.Type.Timestamp.value)
    }

    fun columnTime(selector: String) = columnTime(selector, selector)

    fun columnNumber(selector: String) = columnNumber(selector, selector)

    fun columnNumber(selector: String, text: String) = column {
        selector(selector)
        text(text)
        type(Column.Type.Number.value)



    }
}