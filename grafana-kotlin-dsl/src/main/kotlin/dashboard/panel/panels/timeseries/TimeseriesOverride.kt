package dashboard.panel.panels.timeseries


import AbstractGrafanaObject

class TimeseriesOverride : AbstractGrafanaObject()   {

    fun matchByName(name: String){
        obj("matcher", AbstractGrafanaObject().apply {
            field("id", "byName")
            field("options", name)
        })
    }

    fun matchByTargetRef(targetRef: String){
        obj("matcher", AbstractGrafanaObject().apply {
            field("id", "byFrameRefID")
            field("options", targetRef)
        })
    }



    fun id(id: String) = field("id", id)
    fun options(options: String) = field("options", options)
    fun properties(properties: Properties.() -> Unit) = array("properties", Properties().apply(properties))
}