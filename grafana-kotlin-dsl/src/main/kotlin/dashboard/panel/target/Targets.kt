package dashboard.panel.target

import AbstractGrafanaArray
import dashboard.panel.target.targets.DefaultTarget
import dashboard.panel.target.targets.TestdataTarget
import dashboard.panel.target.targets.PrometheusTarget

class Targets: AbstractGrafanaArray() {
    val refIDs = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N")
    var refIdCounter = 0


    fun testdataTarget(target: TestdataTarget.() -> Unit) = add(TestdataTarget(refIDs[refIdCounter++]).apply(target))
    fun defaultTarget(target: DefaultTarget.() -> Unit) = add(DefaultTarget(refIDs[refIdCounter++]).apply(target))
    fun prometheusTarget(target: PrometheusTarget.() -> Unit) = add(PrometheusTarget(refIDs[refIdCounter++]).apply(target))

}