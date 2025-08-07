package dashboard.panel.panels.table

import AbstractGrafanaArray
import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport
import dashboard.panel.common.fieldconfig.defaults.color.Color


class Properties : AbstractGrafanaArray() {




    fun links(title: String, url: String, targetBlank: Boolean) = add(AbstractGrafanaObject().apply {
        field("id", "links")
        array("value", AbstractGrafanaArray().apply {
            add(AbstractGrafanaObject().apply {
                field("title", title)
                field("url", url)
                field("targetBlank", targetBlank)
            })

        })
    })

    fun filterable() = add(AbstractGrafanaObject().apply {
        field("id", "custom.filterable")
        field("value", true)
    })

    fun unit(unit: StandardOptionsSupport.Unit) = add(AbstractGrafanaObject().apply {
        field("id", "unit")
        field("value", unit.value)
    })

    fun hidden() = add(AbstractGrafanaObject().apply {
        field("id", "custom.hidden")
        field("value", true)
    })


    fun color(color: Color.() -> Unit) = add(AbstractGrafanaObject().apply { field("id", "color") ; obj("value", Color().apply(color)) })

    fun width(width: Int) = add(AbstractGrafanaObject().apply { field("id", "custom.width") ; field("value", width) })
    fun width() = add(AbstractGrafanaObject().apply { field("id", "custom.width") })

    fun cellOptionsColorBackground(mode: Mode, applyToRow: Boolean) = add(AbstractGrafanaObject().apply {
        field("id", "custom.cellOptions")
        obj("value", AbstractGrafanaObject().apply {
            field("type", "color-background")
            field("mode", mode.value)
            field("applyToRow", applyToRow)
        })
    })

    enum class Mode(val value: String) {
        Basic("basic"),
        Gradient("gradient"),
    }
}