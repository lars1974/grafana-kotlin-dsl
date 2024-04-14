package dashboard.panel.target

import AbstractGrafanaObject
import datasource.DataSourceRef

open class Target: AbstractGrafanaObject() {
    fun dataSource(type: DataSourceRef.Type, uid: String, dataSourceRef: DataSourceRef.() -> Unit = {}){
        obj("datasource", DataSourceRef(type, uid).apply(dataSourceRef))
    }
    fun refId(refId: String) = field("refId", refId)

}