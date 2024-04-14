import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ArrayNode

open class AbstractGrafanaArray {
    val arrayNode = ArrayNode(ObjectMapper().nodeFactory)

    fun add(node: AbstractGrafanaObject){
        arrayNode.add(node.node)
    }

    fun reset(){
        arrayNode.removeAll()
    }
}