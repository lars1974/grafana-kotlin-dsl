package dashboard.panel.target.targets.infinity

import AbstractGrafanaObject

class UrlOptions : AbstractGrafanaObject() {
    fun data(data: String) = field("data", data)
    fun method(method: Method) = field("method", method.value)
    fun params(params: Params.() -> Unit) = array("params", Params().apply(params))
    fun params(params: List<Param>) = array("params", Params().apply { params.forEach { add(it) } })

    enum class Method(val value: String) {
        GET("GET"),
        POST("POST")
    }
}


