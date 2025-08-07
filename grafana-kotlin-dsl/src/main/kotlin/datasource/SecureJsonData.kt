package datasource

import AbstractGrafanaObject

class SecureJsonData(): AbstractGrafanaObject() {
    fun apiKeyValue(apiKeyValue: String) = field("apiKeyValue", apiKeyValue)
}