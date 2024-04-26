import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode


open class AbstractGrafanaObject {
    val node = ObjectNode(ObjectMapper().nodeFactory)

    fun field(name: String, value: String) {
        node.put(name, value)
    }

    fun field(name: String, value: Double?) {
        node.put(name, value)
    }

    fun field(name: String, value: Boolean) {
        node.put(name, value)
    }

    fun field(name: String, value: Int?) {
        node.put(name, value)
    }

    fun mixin(template: AbstractGrafanaObject){
        merge(this.node, template.node)
    }

    fun mixin(vararg template: AbstractGrafanaObject){
        template.forEach { merge(this.node, it.node) }
    }


    fun array(name: String, value: AbstractGrafanaArray){
        node.set(name, value.arrayNode) as JsonNode
    }

    fun arrayOfStrings(name: String, values: Array<out String>){
        val array = node.putArray(name)
        values.forEach { array.add(it) }
    }

    fun arrayOfInts(name: String, values: Array<out Int>){
        val array = node.putArray(name)
        values.forEach { array.add(it) }
    }



    fun obj(name: String, value: AbstractGrafanaObject){
        if(node.get(name) == null){
            node.set(name, value.node)
        }
        else merge(node.get(name), value.node)
    }
    fun merge(mainNode: JsonNode, updateNode: JsonNode): JsonNode {
        val fieldNames = updateNode.fieldNames()
        while (fieldNames.hasNext()) {
            val fieldName = fieldNames.next()
            val jsonNode = mainNode[fieldName]
            // if field exists and is an embedded object
            if (jsonNode != null && jsonNode.isObject) {
                merge(jsonNode, updateNode[fieldName])
            } else {
                if (mainNode is ObjectNode) {
                    // Overwrite field
                    val value = updateNode[fieldName]
                    mainNode.set(fieldName, value) as JsonNode
                }
            }
        }
        return mainNode
    }
}