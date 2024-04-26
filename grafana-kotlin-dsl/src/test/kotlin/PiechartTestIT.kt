import client.GrafanaPublisher
import dashboard.DashboardWithContext
import dashboard.LayoutManager
import dashboard.panel.panels.piechart.PiechartOptions
import datasource.DataSource
import datasource.DataSourceRef
import folder.Folder
import org.junit.jupiter.api.Test

class PiechartTestIT {
    val lm = LayoutManager(6, 8)
    val publisher = GrafanaPublisher(token = "admin:password", authType = GrafanaPublisher.AuthType.Basic)
    @Test
    fun test() {
        publisher.publish(Folder {
            uid("test-folder")
            title("tests")
        })

        publisher.publish(DataSource {
            uid("test-datasource")
            name("lars")
            type(DataSourceRef.Type.TestdataDatasource)

            access("proxy")
        })



        publisher.publish(DashboardWithContext {
            folderUid("test-folder")
            overwrite(true)
            dashboard {
                title("piechart test")
                panels {
                    piechart {
                        title("Default")
                        position(lm.next())
                        targets {
                            testdataTarget {
                                dataSource( "test-datasource")
                                seriesCount(10)

                            }
                        }
                    }

                    piechart {
                        title("Donut")
                        position(lm.next())
                        options {
                            pieType(PiechartOptions.PieType.Donut)
                        }
                        targets {
                            testdataTarget {
                                dataSource(DataSourceRef.Type.TestdataDatasource, "test-datasource")
                                seriesCount(10)
                            }
                        }
                    }

                    piechart {
                        title("Donut")
                        position(lm.next())
                        options {
                            pieType(PiechartOptions.PieType.Donut)
                            displayLabels(PiechartOptions.DisplayLabel.Name, PiechartOptions.DisplayLabel.Percent)
                        }
                        targets {
                            testdataTarget {
                                dataSource(DataSourceRef.Type.TestdataDatasource, "test-datasource")
                                seriesCount(5)
                            }
                        }
                    }





                }
            }
        })
    }
}