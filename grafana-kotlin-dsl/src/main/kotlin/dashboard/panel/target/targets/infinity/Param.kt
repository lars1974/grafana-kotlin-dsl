package dashboard.panel.target.targets.infinity

import AbstractGrafanaObject

class Param() : AbstractGrafanaObject() {
    constructor(key: String, value: String) : this() {
        key(key)
        value(value)
    }
    fun key(key: String) = field("key", key)
    fun value(value: String) = field("value", value)
}