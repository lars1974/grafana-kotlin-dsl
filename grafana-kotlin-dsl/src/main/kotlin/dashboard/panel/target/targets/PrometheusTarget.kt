package dashboard.panel.target.targets

import dashboard.panel.target.Target
import datasource.DataSourceRef

class PrometheusTarget(): Target()  {
    constructor(dataSourceUid: String, refId: String): this() {
        dataSource(DataSourceRef.Type.Prometheus, dataSourceUid)
        refId(refId)
    }

    fun prometheusQuery(query: PrometheusQueryBuilder.() -> Unit) = field("expr", PrometheusQueryBuilder().apply(query).q)
    fun range(range: Boolean) = field("range", range)
    fun legendFormat(legendFormat: String) = field("legendFormat", legendFormat)
}