package datasource

import AbstractGrafanaObject

class DataSourceRef(): AbstractGrafanaObject() {


    constructor(type: Type, uid: String) : this() {
        type(type)
        uid(uid)
    }
    fun type(type: Type) = field("type", type.value)
    fun uid(uid: String) = field("uid", uid)

    enum class Type(val value: String){
        TestdataDatasource("testdata"),
        Default("datasource"),
        Prometheus("prometheus")
    }
}