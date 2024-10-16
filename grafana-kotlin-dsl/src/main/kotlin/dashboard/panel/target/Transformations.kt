package dashboard.panel.target

import AbstractGrafanaArray
import dashboard.panel.target.transformations.FilterByName
import dashboard.panel.target.transformations.FormatTime
import dashboard.panel.target.transformations.Organize

class Transformations : AbstractGrafanaArray()  {
    fun organize(organize: Organize.() -> Unit) = add(Organize().apply(organize))
    fun organize(indexByName: List<String>, excludeByName: List<String>, renameByName: Map<String, String>) = add(Organize(indexByName, excludeByName, renameByName))

    fun filterByName(filterByName: FilterByName.() -> Unit) = add(FilterByName().apply(filterByName))
    fun filterByName(vararg names: String) = add(FilterByName(*names))

    fun formatTime(formatTime: FormatTime.() -> Unit) = add(FormatTime().apply(formatTime))
    fun formatTime(timeField: String, outputFormat: String, timezone: String? = null) = add(FormatTime(timeField, outputFormat, timezone))

    fun filterAndOrderByName(vararg names: String) {
        filterByName(*names)
        organize(names.toList(), emptyList(), emptyMap())
    }

}