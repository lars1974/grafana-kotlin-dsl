package dashboard.panel

import dashboard.panel.common.fieldconfig.defaults.color.Color
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdStyle
import dashboard.panel.common.fieldconfig.defaults.thresholds.Thresholds
import dashboard.panel.common.options.legend.Legend
import dashboard.panel.panels.text.TextOptions
import dashboard.panel.panels.text.TextPanel
import dashboard.panel.panels.timeseries.TimeseriesCustom
import dashboard.panel.panels.timeseries.TimeseriesPanel
import datasource.DataSourceRef


object PanelTemplates {

    fun createTimeSeriesMinimum(): TimeseriesPanel {
        return TimeseriesPanel().apply {
            title("Minimal TimeSeries Template")
            type("timeseries")
        }
    }

    fun createTimeSeriesDefault(): TimeseriesPanel {
        return TimeseriesPanel().apply {

            fieldConfig {

                defaults {

                    thresholds {
                        mode(Thresholds.Mode.Absolute)
                        steps {
                            add("green", null)
                            add("red", 80.0)
                        }
                    }
                    custom {
                        gradientMode(TimeseriesCustom.GradientMode.None)
                        axisBorderShow(false)
                        axisCenteredZero(false)
                        axisColorMode(TimeseriesCustom.AxisColorMode.Text)
                        axisLabel("")
                        axisPlacement(TimeseriesCustom.AxisPlacement.Auto)
                        barAlignment(TimeseriesCustom.BarAlignment.Center)
                        drawStyle(TimeseriesCustom.DrawStyle.Line)
                        fillOpacity(0)
                        hideFrom {
                            tooltip(false)
                            viz(false)
                            legend(false)
                        }
                        insertNulls(false)
                        lineInterpolation(TimeseriesCustom.LineInterpolation.Linear)
                        lineWidth(1)
                        pointSize(5)
                        scaleDistribution { type("linear") }
                        showPoints("auto")
                        spanNulls(false)
                        stacking("none", "A")
                        thresholdsStyle(ThresholdStyle.Mode.Off)
                    }
                    color(Color.Mode.PaletteClassic)
                }
            }
            title("Panel Title")
            position(0 , 0, 12, 8)
            targets {
                defaultTarget {
                    refId("A")
                    queryType("randomWalk")
                    dataSource(DataSourceRef.Type.Default, "grafana")
                }
            }
            id(1)
            options {
                legend {
                    calcs()
                    showLegend(true)
                    displayMode(Legend.DisplayMode.List)
                    placement(Legend.Placement.Bottom)
                }
                tooltip("single", "none")
            }
            type("timeseries")
        }
    }

    fun templateText(): Panel {
        return TextPanel().apply {
            options {
                mode(TextOptions.Mode.MarkDown)
            }
        }
    }





}