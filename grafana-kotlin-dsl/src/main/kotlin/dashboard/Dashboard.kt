package dashboard

import AbstractGrafanaObject
import dashboard.panel.Panels
import dashboard.templating.Templates

class Dashboard(): AbstractGrafanaObject(){
    constructor(title: String) : this() {
        this.title(title)
    }

    fun panels(panels: Panels.() -> Unit) = array("panels", Panels().apply(panels))
    fun editable(editable: Boolean) = field("editable", editable)
    fun time(from: String, to: String, time: Time.() -> Unit = {}) = obj("time", Time(from, to).apply(time))
    fun title(title: String) = field("title", title)
    fun tags(tags: List<String>) = arrayOfStrings("tags", tags.toTypedArray())
    fun tags(vararg tags: String) = arrayOfStrings("tags", tags)

    fun timezone(timezone: Timezone) = field("timezone", timezone.value)

    fun templates(templates: Templates.() -> Unit) {
        obj("templating",  AbstractGrafanaObject().apply {
            array("list", Templates().apply(templates))
        })

    }

}