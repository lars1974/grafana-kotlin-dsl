package panel.fieldconfig

import client.GrafanaPublisher
import dashboard.DashBoardWrapper
import dashboard.LayoutManager
import datasource.DataSource
import datasource.DataSourceRef
import org.junit.Test


class TemplatingTestIT {

    @Test
    fun test() {
        val lm = LayoutManager(6, 8)
        val publisher = GrafanaPublisher()

        publisher.publish(DataSource {
            uid("test-prometheus-datasource")
            name("prometheus")
            url("http://prometheus:9090")

            type(DataSourceRef.Type.Prometheus)

            access("proxy")
        })

        publisher.publish(DashBoardWrapper {
            overwrite(true)
            dashboard {

                title("templates test")
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
                }
                templates {
                    custom("custom1") {
                        options {
                            option("test1", "value1")
                            option("test2", "value2")
                            option("test3", "value3")
                        }
                    }
                    prometheus("prometheus1") {
                        dataSource("test-prometheus-datasource")
                        queryLabelValues("status")
                    }
                    prometheus("prometheus2") {
                        dataSource("test-prometheus-datasource")
                        queryLabelName()
                    }
                    prometheus("prometheus3") {
                        dataSource("test-prometheus-datasource")
                        queryMetrics("^http.*")
                    }
                    textbox("textbox1") {}
                    constant("constant1") {
                        query("test")
                    }

                }
            }
        })
    }

}