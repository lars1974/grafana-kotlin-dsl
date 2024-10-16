package dashboard.panel.panels.dashlist

import AbstractGrafanaObject

class DashlistOptions: AbstractGrafanaObject() {
    fun keepTime(keepTime: Boolean) = field("keepTime", keepTime)
    fun includeVars(includeVars: Boolean) = field("includeVars", includeVars)
    fun showStarred(showStarred: Boolean) = field("showStarred", showStarred)
    fun showRecentlyViewed(showRecentlyViewed: Boolean) = field("showRecentlyViewed", showRecentlyViewed)
    fun showSearch(showSearch: Boolean) = field("showSearch", showSearch)
    fun showHeadings(showHeadings: Boolean) = field("showHeadings", showHeadings)
    fun maxItems(maxItems: Int) = field("maxItems", maxItems)
    fun query(query: String) = field("query", query)
    fun folderUID(folderUID: String) = field("folderUID", folderUID)
    fun tags(vararg tags: String) = arrayOfStrings("tags", tags)
}