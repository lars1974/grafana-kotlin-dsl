package dashboard.panel.panels.timeseries

import AbstractGrafanaObject
import dashboard.panel.common.fieldconfig.defaults.thresholds.ThresholdStyle

class TimeseriesCustom: AbstractGrafanaObject() {

    fun axisBorderShow(axisBorderShow: Boolean) = field("axisBorderShow", axisBorderShow)
    fun axisCenteredZero(axisCenteredZero: Boolean) = field("axisCenteredZero", axisCenteredZero)
    fun axisColorMode(axisColorMode: AxisColorMode) = field("axisColorMode", axisColorMode.value)
    fun axisLabel(axisLabel: String) = field("axisLabel", axisLabel)
    fun axisWidth(axisWidth: Int) = field("axisWidth", axisWidth)
    fun axisPlacement(axisPlacement: AxisPlacement) = field("axisPlacement", axisPlacement.value)
    fun axisSoftMin(axisSoftMin: Double) = field("axisSoftMin",axisSoftMin)
    fun axisSoftMax(axisSoftMax: Double) = field("axisSoftMax",axisSoftMax)
    fun barAlignment(barAlignment: BarAlignment) = field("barAlignment", barAlignment.value)
    fun fillOpacity(fillOpacity: Int) = field("fillOpacity", fillOpacity)
    fun gradientMode(gradientMode: GradientMode) = field("gradientMode", gradientMode.value)
    fun axisGridShow(axisGridShow: AxisGridShow) { if(axisGridShow != AxisGridShow.Auto) field("axisGridShow", axisGridShow.value.toBoolean())}
    fun insertNulls(insertNulls: Boolean) = field("insertNulls", insertNulls)
    fun lineInterpolation(lineInterpolation: LineInterpolation) = field("lineInterpolation", lineInterpolation.value)
    fun lineWidth(lineWidth: Int) = field("lineWidth", lineWidth)
    fun pointSize(pointSize: Int) = field("pointSize", pointSize)
    fun drawStyle(drawStyle: DrawStyle) = field("drawStyle", drawStyle.value)
    fun hideFrom (hideFrom: HideFrom.() -> Unit) = obj("hideFrom", HideFrom().apply(hideFrom))
    fun scaleDistribution(scaleDistribution: ScaleDistrubution.() -> Unit) = obj("scaleDistribution", ScaleDistrubution().apply(scaleDistribution))
    fun showPoints(showPoints: String) = field("showPoints", showPoints)
    fun spanNulls(spanNulls: Boolean) = field("spanNulls", spanNulls)
    fun lineStyle(fill: LineStyle.Fill, pattern: List<Int>) = obj("lineStyle", LineStyle(fill, pattern))

    fun stacking(stacking: Stacking.() -> Unit) = obj("stacking", Stacking().apply(stacking))
    fun stacking(mode: String, group: String, stacking: Stacking.() -> Unit = {}) = obj("stacking", Stacking(mode, group).apply(stacking))

    fun thresholdsStyle(thresholdsStyle: ThresholdStyle.() -> Unit) = obj("thresholdsStyle", ThresholdStyle().apply(thresholdsStyle))
    fun thresholdsStyle(mode: ThresholdStyle.Mode, thresholdsStyle: ThresholdStyle.() -> Unit = {}) = obj("thresholdsStyle", ThresholdStyle(mode).apply(thresholdsStyle))



    enum class GradientMode(val value: String){
        None("none"),
        Opacity("opacity"),
        Hue("hue")
    }

    enum class LineInterpolation(val value: String){
        Linear("linear"),
        Smooth("smooth"),
        StepBefore("stepBefore"),
        StepAfter("stepAfter")
    }

    enum class BarAlignment(val value: Int){
        Left(-1),
        Center(0),
        Right(1)
    }

    enum class DrawStyle(val value: String){
        Point("point"),
        Line("line"),
        Bars("bars")
    }

    enum class AxisColorMode(val value: String){
        Series("series"),
        Text("text")
    }

    enum class AxisGridShow(val value: String){
        On("true"),
        Off("false"),
        Auto("auto")
    }

    enum class AxisPlacement(val value: String){
        Auto("auto"),
        Left("left"),
        Right("right"),
        Hidden("hidden")
    }
}