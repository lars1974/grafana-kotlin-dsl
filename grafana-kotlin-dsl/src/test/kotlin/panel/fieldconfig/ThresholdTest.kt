package panel.fieldconfig

import dashboard.panel.common.fieldconfig.defaults.thresholds.Thresholds
import dashboard.panel.panels.timeseries.TimeseriesPanel
import org.junit.jupiter.api.Test


class ThresholdTest {
    @Test
    fun test(){
        val panel = TimeseriesPanel().apply{
            fieldConfig {
                defaults {
                    thresholds {
                        steps {
                            add {
                                color("red")
                                value(null)
                            }
                            add {
                                color("yellow")
                                value(10.0)
                            }
                        }
                    }
                }
            }
        }
        println(panel.node.toPrettyString())
    }

    @Test
    fun test2(){
        val panel = TimeseriesPanel().apply{
            fieldConfig {
                defaults {
                    thresholds(Thresholds.Mode.Absolute, listOf(null, 10.0), listOf("green", "blue"))
                }
            }
        }
        println(panel.node.toPrettyString())
    }
}