import client.GrafanaPublisher
import dashboard.DashboardWithContext
import dashboard.panel.common.fieldconfig.defaults.color.Color
import dashboard.panel.panels.stat.StatOptions
import dashboard.panel.panels.stat.StatPanel
import datasource.DataSource
import datasource.DataSourceRef
import org.junit.jupiter.api.Test


class TemplateTest {
    @Test
    fun test() {
        val publisher = GrafanaPublisher(token = "admin:password", authType = GrafanaPublisher.AuthType.Basic)

        publisher.publish(DataSource {
            uid("test-prometheus-datasource")
            name("prometheus")
            url("http://prometheus:9090")

            type(DataSourceRef.Type.Prometheus)

            access("proxy")
        })

        publisher.publish(DashboardWithContext().apply {
            dashboard("lars test template") {
                editable(true)
                overwrite(true)
                tags("test")
                time("now-6h", "now")
                panels {

                    stat("") {
                        mixin(standalonePurpleDigit(), fontTemplate(20))
                        transparent(true)


                        fieldConfig {
                            defaults {
                                color {
                                  fixedColor("red")
                                }
                            }
                        }

                        targets {
                            prometheusTarget("test-prometheus-datasource") {
                                prometheusQuery {
                                    sum(sumOverTime(metric("http_server_requests_seconds_count", filters(eq("method", "post")))))
                                }
                            }

                        }
                    }
                }
            }
        })
    }

    fun standalonePurpleDigit(): StatPanel {
        return StatPanel().apply {
            fieldConfig {
                defaults {
                    color {
                        mode(Color.Mode.Single)
                        fixedColor("purple")
                    }
                }
            }

            options {
                textMode(StatOptions.TextMode.Value)
                colorMode(StatOptions.ColorMode.Value)
                graphMode(StatOptions.GraphMode.None)
            }
        }
    }

    fun fontTemplate(valueSize: Int): StatPanel {
        return StatPanel().apply {
            options {
                text {
                    valueSize(valueSize)

                }
            }
        }
    }
}