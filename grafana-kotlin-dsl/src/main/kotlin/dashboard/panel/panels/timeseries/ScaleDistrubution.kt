package dashboard.panel.panels.timeseries

import AbstractGrafanaObject

class ScaleDistrubution: AbstractGrafanaObject() {
    fun type(type: Type) = field("type", type.value)
    fun linearThreshold(linearThreshold: Int) = field("linearThreshold", linearThreshold)
    fun log(log: Log) = field("log", log.value)

    enum class Log(val value: Int){
        Log2(2),
        Log10(10)
    }

    enum class Type(val value: String){
        Symlog("symlog"),
        Log("log"),
        Linear("linear")
    }
}