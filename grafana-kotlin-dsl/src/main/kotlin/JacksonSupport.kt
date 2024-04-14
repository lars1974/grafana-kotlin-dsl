
interface JacksonSupport {
    fun field(name: String, value: String)

    fun field(name: String, value: Boolean)

    fun field(name: String, value: Int?)

    fun arrayOfStrings(name: String, values: Array<out String>)

    fun array(name: String, value: AbstractGrafanaArray)

    fun obj(name: String, value: AbstractGrafanaObject)
}