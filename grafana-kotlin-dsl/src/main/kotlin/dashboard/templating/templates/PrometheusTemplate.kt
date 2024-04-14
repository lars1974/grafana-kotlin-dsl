package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template
import datasource.DataSourceRef

class PrometheusTemplate(name: String): Template(name) {
    init {
        type("query")
    }

    fun dataSource(uid: String, dataSourceRef: DataSourceRef.() -> Unit = {}){
        obj("datasource", DataSourceRef(DataSourceRef.Type.Prometheus, uid).apply(dataSourceRef))
    }

    fun queryLabelValues(field: String){
        obj("query", AbstractGrafanaObject().apply {
            field("query", "label_values($field)")
            field("refId", "PrometheusVariableQueryEditor-VariableQuery")
        })
    }
    fun queryLabelName(){
        obj("query", AbstractGrafanaObject().apply {
            field("query", "label_names()")
            field("refId", "PrometheusVariableQueryEditor-VariableQuery")
        })
    }
    fun queryMetrics(regex: String) {
        obj("query", AbstractGrafanaObject().apply {
            field("query", "metrics($regex)")
            field("refId", "PrometheusVariableQueryEditor-VariableQuery")
        })
    }



}