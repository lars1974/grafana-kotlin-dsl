package dashboard.templating.templates

import AbstractGrafanaObject
import dashboard.templating.Template
import datasource.DataSourceRef

class InfinityTemplate(name: String) : Template(name) {
    init {
        type("query")
    }

    fun refresh(value: Int) = field("refresh", value)
    fun regex(value: String) = field("regex", value)
    fun definition(value: String) = field("definition", value)
    fun sort(value: Int) = field("sort", value)

    fun options(value: List<String>) = arrayOf("options", value)



    fun dataSource(uid: String, dataSourceRef: DataSourceRef.() -> Unit = {}) {
        obj("datasource", DataSourceRef(DataSourceRef.Type.Infinity, uid).apply(dataSourceRef))
    }

    fun query(infinityQuery: InfinityQuery.() -> Unit) {
        obj("query", AbstractGrafanaObject().apply {
            field("query", "")
            field("queryType", "infinity")
            obj("infinityQuery", InfinityQuery().apply(infinityQuery))
        })
    }

}
