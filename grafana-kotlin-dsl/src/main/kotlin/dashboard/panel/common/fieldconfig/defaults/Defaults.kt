package dashboard.panel.common.fieldconfig.defaults

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.defaults.color.Color

open class Defaults: AbstractGrafanaObject() {
    fun color(mode: Color.Mode, color: Color.() -> Unit = {}){ obj("color", Color(mode).apply(color)) }

    fun color(color: Color.() -> Unit){ obj("color", Color().apply(color)) }
}