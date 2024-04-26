import client.GrafanaPublisher
import dashboard.DashBoardWrapper
import dashboard.LayoutManager
import dashboard.Timezone
import dashboard.panel.common.Calcs
import dashboard.panel.common.options.legend.Legend
import dashboard.panel.common.options.tooltip.Tooltip
import dashboard.panel.panels.timeseries.LineStyle
import dashboard.panel.panels.timeseries.ScaleDistrubution
import dashboard.panel.panels.timeseries.TimeseriesCustom
import folder.Folder
import org.junit.jupiter.api.Test

class TimeSeriesTestIT {
    val lm = LayoutManager(6,8)
    val publisher = GrafanaPublisher(token = "admin:test", authType = GrafanaPublisher.AuthType.Basic)

    @Test
    fun test() {
        publisher.publish(Folder {
            uid("test-folder")
            title("tests")
            overwrite(true)
        })

        publisher.publish(Folder {
            uid("timeseries-folder")
            title("Timeseries")
            overwrite(true)
            this.parentUid("test-folder")
        })

        publisher.publish(DashBoardWrapper {
            folderUid("timeseries-folder")
            overwrite(true)
            dashboard {
                title("timeseries test")
                panels {
                    timeseries {
                        title("Default")
                        position(lm.next())
                    }
                    timeseries {
                        title("Tooltip Multi")
                        position(lm.next())
                        options {
                            tooltip {
                                mode(Tooltip.Mode.Multi)
                                sort(Tooltip.Sort.Asc)
                            }
                        }
                        targets {
                            defaultTarget {
                                refId("A")
                                queryType("randomWalk")
                                dataSource()
                            }
                            defaultTarget {
                                refId("B")
                                queryType("randomWalk")
                                dataSource()
                            }
                        }
                    }
                    timeseries {
                        title("Table Legend at Bottom")
                        position(lm.next())
                        options {
                            legend {
                                displayMode(Legend.DisplayMode.Table)
                                placement(Legend.Placement.Bottom)
                                calcs(Calcs.Count, Calcs.Sum, Calcs.Diffperc, Calcs.Delta)
                            }
                        }
                    }
                    timeseries {
                        title("No Legend")
                        position(lm.next())
                        options {
                            legend {
                                showLegend(false)
                            }
                        }
                    }
                    timeseries {
                        title("Time Zone")
                        position(lm.next())
                        options {
                            timezone(Timezone.UTC, Timezone.Browser)
                        }
                    }
                    timeseries {
                        title("Axis Right")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    axisPlacement(TimeseriesCustom.AxisPlacement.Right)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Axis Hidden")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    axisPlacement(TimeseriesCustom.AxisPlacement.Hidden)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Axis Logarithmic")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    scaleDistribution {
                                        type(ScaleDistrubution.Type.Log)
                                        log(ScaleDistrubution.Log.Log10)
                                    }
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Axis Label")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    axisLabel("Test Label")
                                    axisWidth(100)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Grid Off")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    axisGridShow(TimeseriesCustom.AxisGridShow.Off)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Axis Soft min and max")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    axisSoftMin(0.0)
                                    axisSoftMax(125.0)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Draw Style Point")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    drawStyle(TimeseriesCustom.DrawStyle.Point)
                                    pointSize(10)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Draw Style Bars")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    drawStyle(TimeseriesCustom.DrawStyle.Bars)
                                    barAlignment(TimeseriesCustom.BarAlignment.Center)
                                }
                            }
                        }
                    }
                    timeseries {
                        title("Draw Style Line")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    drawStyle(TimeseriesCustom.DrawStyle.Line)
                                    lineWidth(4)
                                }
                            }
                        }
                    }

                    timeseries {
                        title("Draw Style Dot Line")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    drawStyle(TimeseriesCustom.DrawStyle.Line)
                                    lineStyle(LineStyle.Fill.Dash, listOf(3,24,3,6,3,6,3,6))
                                }
                            }
                        }
                    }

                    timeseries {
                        title("Value Mappings")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                mappings {
                                    range("high", 30.0, 100.0)
                                    range("normal", 10.0, 30.0)
                                    range("low", 0.0, 10.0)
                                }
                                custom {
                                }

                            }
                        }
                    }

                    timeseries {
                        title("Stack")
                        position(lm.next())
                        fieldConfig {
                            defaults {
                                custom {
                                    stacking("normal", "A")
                                    gradientMode(TimeseriesCustom.GradientMode.Opacity)
                                    fillOpacity(50)
                                }

                            }
                        }
                        targets {
                            defaultTarget {
                                refId("A")
                                queryType("randomWalk")
                                dataSource()
                            }
                            defaultTarget {
                                refId("B")
                                queryType("randomWalk")
                                dataSource()
                            }
                        }
                    }

                    timeseries {
                        title("Links")
                        position(lm.next())
                        links {
                            link("open google new window", "https://www.google.dk", true)
                            link("open google same window", "https://www.google.dk", false)
                        }
                    }


                }
            }
        })
    }
}