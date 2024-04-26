package dashboard

import AbstractGrafanaObject

class DashboardWithContext(): AbstractGrafanaObject() {
    constructor(dashboardRoot: DashboardWithContext.() -> Unit) : this() {
        this.apply(dashboardRoot)
    }

    fun dashboard(dashboard: Dashboard.() -> Unit) = obj("dashboard", Dashboard().apply(dashboard))

    fun dashboard(title: String, dashboard: Dashboard.() -> Unit) = obj("dashboard", Dashboard(title).apply(dashboard))
    fun folderUid(folderUid: String) = field("folderUid", folderUid)
    fun message(message: String) = field("message", message)
    fun overwrite(overwrite: Boolean) = field("overwrite", overwrite)
}