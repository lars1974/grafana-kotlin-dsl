package dashboard.panel.common.fieldconfig.defaults.color

import JacksonSupport

interface ColorSupport: JacksonSupport  {
    fun color(mode: Color.Mode, color: Color.() -> Unit = {}){ obj("color", Color(mode).apply(color)) }

    fun color(color: Color.() -> Unit){ obj("color", Color().apply(color)) }

}