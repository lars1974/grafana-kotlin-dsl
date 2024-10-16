package dashboard.panel.target.targets.infinity

import AbstractGrafanaObject

class Column : AbstractGrafanaObject(){
    fun selector(sizing: String) = field("selector", sizing)
    fun text(text: String) = field("text", text)
    fun timestampFormat(format: String) = field("timestampFormat", format)
    fun type(type: String) = field("type", type)




    enum class Type(val value: String) {
        Timestamp("timestamp"),
        Number("number")
    }
}