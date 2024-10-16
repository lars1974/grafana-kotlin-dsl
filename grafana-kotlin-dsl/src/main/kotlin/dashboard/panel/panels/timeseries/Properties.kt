package dashboard.panel.panels.timeseries

import AbstractGrafanaArray
import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.StandardOptionsSupport
import dashboard.panel.common.fieldconfig.defaults.color.Color


class Properties : AbstractGrafanaArray() {
    fun drawStyle(drawStyle: TimeseriesCustom.DrawStyle) = add(AbstractGrafanaObject().apply {
        field("id", "custom.drawStyle")
        field("value", drawStyle.value)
    })

    fun axisPlacement(axisPlacement: TimeseriesCustom.AxisPlacement) = add(AbstractGrafanaObject().apply {
        field("id", "custom.axisPlacement")
        field("value", axisPlacement.value)
    })

    fun axisCenteredZero() = add(AbstractGrafanaObject().apply {
        field("id", "custom.axisCenteredZero")
        field("value", true)
    })

    fun axisGridShow() = add(AbstractGrafanaObject().apply {
        field("id", "custom.axisGridShow")
        field("value", true)
    })

    fun axisBorderShow() = add(AbstractGrafanaObject().apply {
        field("id", "custom.axisBorderShow")
        field("value", true)
    })

    fun lineWidth(width: Int) = add(AbstractGrafanaObject().apply {
        field("id", "custom.lineWidth")
        field("value", width)
    })

    fun stacking(stacking: Stacking.() -> Unit) = add(AbstractGrafanaObject().apply {
        field("id", "custom.stacking")
        obj("value",Stacking().apply(stacking))
    })

    fun fillOpacity(fillOpacity: Int) = add(AbstractGrafanaObject().apply {
        field("id", "custom.fillOpacity")
        field("value", fillOpacity)
    })



    fun color(color: Color.() -> Unit) = add(AbstractGrafanaObject().apply { field("id", "color") ; obj("value", Color().apply(color)) })
}