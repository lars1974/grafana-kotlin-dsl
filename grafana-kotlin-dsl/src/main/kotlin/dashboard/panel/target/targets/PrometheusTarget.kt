package dashboard.panel.target.targets

import dashboard.panel.target.Target

class PrometheusTarget(): Target()  {
    constructor(refId: String): this() {
        refId(refId)
    }

    fun prometheusQuery(query: PrometheusQueryBuilder.() -> Unit) = field("expr", PrometheusQueryBuilder().apply(query).q)
    fun range(range: Boolean) = field("range", range)
    fun legendFormat(legendFormat: String) = field("legendFormat", legendFormat)
}