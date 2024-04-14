import client.GrafanaPublisher
import dashboard.DashBoardWrapper
import dashboard.LayoutManager
import dashboard.panel.common.Calcs
import folder.Folder
import org.junit.jupiter.api.Test

class GaugeTest {
    val lm = LayoutManager(6, 8)
    val publisher = GrafanaPublisher(token = TestTokens.getToken())

    @Test
    fun test() {
        publisher.publish(Folder {
            uid("test-folder")
            title("tests")
            overwrite(true)
        })



        publisher.publish(DashBoardWrapper {
            folderUid("test-folder")
            overwrite(true)
            dashboard {
                title("gauge test")
                panels {
                    gauge {
                        title("Default")
                        position(lm.next())
                    }

                    gauge {
                        title("Show all values")
                        position(lm.next())
                        options {
                            reduceOptions {
                                values(false)
                                calcs(Calcs.Count)
                            }
                        }
                    }

                    gauge {
                        title("Show all values")
                        position(lm.next())
                        options {
                            reduceOptions {
                                values(true)
                                limit(10)
                            }
                        }
                    }

                    gauge {
                        title("Hide Threshold markers")
                        position(lm.next())
                        options {
                            showThresholdMarkers(false)
                        }
                    }

                    gauge {
                        title("show Threshold labels")
                        position(lm.next())
                        options {
                            showThresholdLabels(true)
                        }
                    }

                    gauge {
                        title("mappings")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                mappings {
                                    range("Cold", 0.0, 10.0)
                                    range("Medium", 10.0, 40.0)
                                    range("Hot", 40.0, 100.0)
                                }
                            }
                        }
                    }
                }
            }
        })
    }
}