
import client.GrafanaPublisher
import dashboard.DashBoardWrapper
import dashboard.LayoutManager
import dashboard.panel.common.Calcs
import dashboard.panel.panels.stat.StatOptions
import folder.Folder
import org.junit.jupiter.api.Test



class StatTestIT {
    val lm = LayoutManager(6, 8)
    val publisher = GrafanaPublisher(token = "admin:test", authType = GrafanaPublisher.AuthType.Basic)
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
                title("stat test")
                panels {
                    stat {
                        title("Default")
                        position(lm.next())
                    }

                    stat {
                        title("Default")
                        position(lm.next())
                        options {
                            orientation(StatOptions.Orientation.Vertical)
                        }
                    }

                    stat {
                        title("No graph")
                        position(lm.next())
                        options {
                            graphMode(StatOptions.GraphMode.None)
                        }
                    }

                    stat {
                        title("Background")
                        position(lm.next())
                        options {
                            colorMode(StatOptions.ColorMode.Background)
                        }
                    }

                    stat {
                        title("Value and name")
                        position(lm.next())
                        options {
                            textMode(StatOptions.TextMode.ValueAndName)
                        }
                    }

                    stat {
                        title("Center")
                        position(lm.next())
                        options {
                            justifyMode(StatOptions.JustifyMode.Center)
                        }
                    }

                    stat {
                        title("Percentage change")
                        position(lm.next())
                        options {
                            showPercentChange(true)
                        }
                    }

                    stat {
                        title("Calc count")
                        position(lm.next())
                        options {
                            reduceOptions {
                                this.calcs(Calcs.Count)
                            }
                        }
                    }



                }
            }
        })
    }




}