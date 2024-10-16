package dashboard.panel.target.targets.infinity

import dashboard.panel.target.Target
import datasource.DataSourceRef

open class InfinityTarget(): Target()  {
    constructor(refId: String): this() {
        refId(refId)
    }

    constructor(dataSourceUid: String, refId: String): this() {
        dataSource(DataSourceRef.Type.Infinity, dataSourceUid)
        refId(refId)
    }

    fun type(type: Type) = field("type", type.value)
    fun format(format: Format) = field("format", format.value)
    fun parser(parser: Parser) = field("parser", parser.value)
    fun url(url: String) = field("url", url)
    fun source(source: Source) = field("source", source.value)
    fun rootSelector(rootSelector: String) = field("root_selector", rootSelector)
    fun urlOptions(urlOptions: UrlOptions.() -> Unit) {
        obj("url_options", UrlOptions().apply(urlOptions))
    }
    fun uql(uql: String) = field("uql", uql)

    fun columns(columns: Columns.() -> Unit) {
        array("columns", Columns().apply(columns))
    }

    enum class Parser(val value: String) {
        Backend("backend"),
        UQL("uql"),
    }

    enum class Format(val value: String) {
        TimeSeries("timeseries"),
        Table("table"),
    }

    enum class Source(val value: String) {
        Url("url"),
    }

    enum class Type(val value: String) {
        Json("json"),
    }

}