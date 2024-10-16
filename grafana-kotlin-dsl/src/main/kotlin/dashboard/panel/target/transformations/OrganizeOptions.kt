package dashboard.panel.target.transformations

import AbstractGrafanaObject

class OrganizeOptions : AbstractGrafanaObject() {
    fun indexByName(vararg columns: String){
        obj("indexByName", AbstractGrafanaObject().apply {
            columns.toList().forEachIndexed { index, name ->   field(name, index ) }
        })
    }

    fun excludeByName(vararg columns: String){
        obj("excludeByName", AbstractGrafanaObject().apply {
            columns.toList().forEach { name ->   field(name, true ) }
        })
    }

    fun renameByName(map: Map<String, String>){
        obj("renameByName", AbstractGrafanaObject().apply {
            map.forEach { e ->   field(e.key, e.value ) }
        })
    }




}