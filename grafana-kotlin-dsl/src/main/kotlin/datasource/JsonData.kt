package datasource

import AbstractGrafanaObject

class JsonData(): AbstractGrafanaObject() {
    fun allowedHosts(allowedHosts: List<String>) = arrayOfStrings("allowedHosts", allowedHosts.toTypedArray())
    fun apiKeyKey(apiKeyKey: String) = field("apiKeyKey", apiKeyKey)
    fun authMethod(authMethod: String) = field("auth_method", authMethod)


}