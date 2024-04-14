import client.GrafanaPublisher
import dashboard.DashBoardWrapper
import dashboard.LayoutManager
import dashboard.panel.common.Calcs
import dashboard.panel.common.fieldconfig.defaults.thresholds.Thresholds
import dashboard.panel.panels.stat.StatOptions
import datasource.DataSource
import datasource.DataSourceRef
import folder.Folder
import org.junit.jupiter.api.Test

class PrometheusTest {
    val lm = LayoutManager(6, 8)
    val publisher = GrafanaPublisher(token = TestTokens.getToken())

    @Test
    fun test() {
        publisher.publish(Folder {
            uid("prometheus-test-folder")
            title("tests")
        })

        publisher.publish(DataSource {
            uid("test-prometheus-datasource")
            name("prometheus")
            url("http://prometheus:9090")

            type(DataSourceRef.Type.Prometheus)

            access("proxy")
        })



        publisher.publish(DashBoardWrapper {
            folderUid("prometheus-test-folder")
            overwrite(true)
            dashboard {

                title("prometheus test")
                panels {
                    timeseries {
                        title("Default")
                        position(lm.next())
                        targets {
                            prometheusTarget {
                                dataSource(DataSourceRef.Type.Prometheus, "test-prometheus-datasource")
                                range(true)
                                prometheusQuery {

                                    sumBy(rate(metric("http_server_requests_seconds_count", filters(eq("method", "post")))), "status")

                                }
                                legendFormat("{{status}}")

                            }
                        }
                    }
                    stat {
                        title("Default")
                        position(lm.next())

                        options {
                            reduceOptions {
                                calcs(Calcs.Diff)
                            }
                            //graphMode(StatOptions.GraphMode.None)
                        }
                        fieldConfig {
                            defaults {
                                thresholds(Thresholds.Mode.Absolute, listOf(null), listOf("green"))
                            }
                        }
                        targets {
                            prometheusTarget {
                                dataSource(DataSourceRef.Type.Prometheus, "test-prometheus-datasource")
                                range(true)
                                prometheusQuery {
                                    sumOverTime(metric("http_server_requests_seconds_count", filters(eq("status", "200"), eq("method", "post"))))

                                }
                            }
                        }
                    }
                    stat {
                        title("Errors")
                        position(lm.next())
                        options {
                            reduceOptions {
                                calcs(Calcs.Delta)
                            }
                            graphMode(StatOptions.GraphMode.None)
                        }
                        fieldConfig {
                            defaults {

                            }
                        }
                        targets {
                            prometheusTarget {
                                dataSource(DataSourceRef.Type.Prometheus, "test-prometheus-datasource")
                                range(true)
                                prometheusQuery {
                                    sumOverTime(metric("http_server_requests_seconds_count", filters(eq("status", "400"), eq("method", "post"))))

                                }
                            }
                        }
                    }
                }
            }
        })
    }
}