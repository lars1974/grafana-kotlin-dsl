package datasource

import AbstractGrafanaObject

class DataSource(): AbstractGrafanaObject() {
    constructor(dataSource: DataSource.() -> Unit) : this() {
        this.apply(dataSource)
    }


    fun uid(uid: String) = field("uid",uid)
    fun name(name: String) = field("name", name)
    fun type(type: DataSourceRef.Type) = field("type", type.value)
    fun url(url: String) = field("url", url)
    fun access(access: String) = field("access", access)
    fun jsonData(jsonData: JsonData.() -> Unit) =  obj("jsonData", JsonData().apply(jsonData))
    fun secureJsonData(secureJsonData: SecureJsonData.() -> Unit) =  obj("secureJsonData", SecureJsonData().apply(secureJsonData))


}