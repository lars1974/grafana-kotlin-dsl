package dashboard.panel.target.transformations

import AbstractGrafanaObject

class FormatTimeOptions : AbstractGrafanaObject() {
    fun timeField(timeField: String) = field("timeField", timeField)
    fun outputFormat(outputFormat: String) = field("outputFormat", outputFormat)
    fun useTimezone(useTimezone: Boolean) = field("useTimezone", useTimezone)
    fun timezone(timezone: String) = field("timezone", timezone)


}