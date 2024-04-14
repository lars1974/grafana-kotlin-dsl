package dashboard.panel.target.targets

import dashboard.panel.target.Target
import datasource.DataSourceRef

class DefaultTarget(): Target()  {
    constructor(refId: String): this() {
        refId(refId)
    }

    fun dataSource() = dataSource(DataSourceRef.Type.Default, "grafana")

    fun queryType(queryType: String) = field("queryType", queryType)
}