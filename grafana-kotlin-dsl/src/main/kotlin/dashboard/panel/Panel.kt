package dashboard.panel

import AbstractGrafanaObject
import datasource.DataSourceRef
import dashboard.panel.target.Targets
import dashboard.panel.common.GridPos
import dashboard.panel.common.Links


open class Panel() : AbstractGrafanaObject(){
    constructor(panel: Panel.() -> Unit) : this() {
        this.apply(panel)
    }

    constructor(title: String, panel: Panel.() -> Unit) : this() {
        title(title)
        this.apply(panel)
    }

    fun transparent(transparent: Boolean) = field("transparent", transparent)

    fun title(title: String) = field("title", title)

    fun type(type: String) = field("type", type)

    fun position(pos: GridPos.Position, gridPos: GridPos.() -> Unit = {}) = obj("gridPos", GridPos(pos).apply(gridPos))

    fun position(x: Int, y: Int, w: Int, h: Int, gridPos: GridPos.() -> Unit = {}) = obj("gridPos", GridPos(x, y, w, h).apply(gridPos))


    fun dataSource(type: DataSourceRef.Type, uid: String, dataSourceRef: DataSourceRef.() -> Unit = {}) = obj("datasource", DataSourceRef(type, uid).apply(dataSourceRef))

    fun targets(targets: Targets.() -> Unit) = array("targets", Targets().apply(targets))

    fun id(id: Int?) = field("id", id)

    fun links(links: Links.() -> Unit) = array("links", Links().apply(links))

}