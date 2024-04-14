package dashboard.panel.common.options

import AbstractGrafanaObject
import dashboard.Timezone

open class Options: AbstractGrafanaObject() {
    fun timezone(vararg timezone: Timezone) {
        arrayOfStrings("timezone", timezone.map { it.value }.toTypedArray())
    }


}