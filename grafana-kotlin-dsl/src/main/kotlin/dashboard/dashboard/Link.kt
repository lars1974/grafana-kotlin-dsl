package dashboard.dashboard

import AbstractGrafanaObject

class Link() : AbstractGrafanaObject(){

    fun asDropdown(asDropdown: Boolean) = field("asDropdown", asDropdown)
    fun icon(icon: String) = field("icon", icon)
    fun includeVars(includeVars: Boolean) = field("includeVars", includeVars)
    fun keepTime(keepTime: Boolean) = field("keepTime", keepTime)
    fun tags(vararg tags: String) = arrayOfStrings("tags", tags)
    fun targetBlank(targetBlank: Boolean) = field("targetBlank", targetBlank)
    fun title(title: String) = field("title", title)
    fun tooltip(tooltip: String) = field("tooltip", tooltip)
    fun type(type: String) = field("type", type)
    fun url(url: String) = field("url", url)


}