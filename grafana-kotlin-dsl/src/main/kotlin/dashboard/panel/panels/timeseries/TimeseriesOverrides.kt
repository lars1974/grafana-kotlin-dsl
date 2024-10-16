package dashboard.panel.panels.timeseries

import AbstractGrafanaArray

class TimeseriesOverrides : AbstractGrafanaArray()   {
    fun override(override: TimeseriesOverride.() -> Unit) = add(TimeseriesOverride().apply(override))

    fun overrideByName(name: String, properties: Properties.() -> Unit) {
       override {
           matchByName(name)
           properties {
               apply(properties)
           }
       }
    }

    fun overrideByTargetRef(targetRef: String, properties: Properties.() -> Unit) {
        override {
            matchByTargetRef(targetRef)
            properties {
                apply(properties)
            }
        }
    }
}