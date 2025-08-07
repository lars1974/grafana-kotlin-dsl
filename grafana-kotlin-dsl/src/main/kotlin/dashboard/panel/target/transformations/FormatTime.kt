package dashboard.panel.target.transformations

import AbstractGrafanaObject

class FormatTime()  : AbstractGrafanaObject() {
    constructor(timeField: String, outputFormat: String, timezone: String? = null) : this() {
        options {
            timeField(timeField)
            outputFormat(outputFormat)
            if(timezone != null) {
                timezone(timezone)
                useTimezone(true)
            }
        }
    }

    init {
        field("id", "formatTime")
    }

    fun options(options: FormatTimeOptions.() -> Unit) = obj("options", FormatTimeOptions().apply(options))


}

