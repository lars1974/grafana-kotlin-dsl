package dashboard.panel.panels.canvas

import AbstractGrafanaObject

class Placement(): AbstractGrafanaObject() {

    fun left(left: Int) = field("left", left)
    fun right(right: Int) = field("right", right)
    fun top(top: Int) = field("top", top)
    fun bottom(bottom: Int) = field("bottom", bottom)
    fun width(width: Int) = field("width", width)
    fun height(height: Int) = field("height", height)
    fun rotation(rotation: Int) = field("rotation", rotation)

    open class HorizontalConstraint(val horizontal: Constraint.Horizontal)
    open class VerticalConstraint(val vertical: Constraint.Vertical)


    class LeftRight(val left: Int, val right: Int)  : HorizontalConstraint(Constraint.Horizontal.LeftRight)
    class CenterVertical(val top: Int, val height: Int): VerticalConstraint(Constraint.Vertical.CenterHeight)
    class CenterHorizontal(val left: Int, val width: Int): HorizontalConstraint(Constraint.Horizontal.CenterWidth)
    class LeftWidth(val left: Int, val width: Int): HorizontalConstraint(Constraint.Horizontal.LeftWidth)
    class RightWidth(val right: Int, val width: Int): HorizontalConstraint(Constraint.Horizontal.RightWidth)
    class TopBottom(val top: Int, val bottom: Int): VerticalConstraint(Constraint.Vertical.TopBottom)
    class TopHeight(val top: Int, val height: Int): VerticalConstraint(Constraint.Vertical.TopHeight)
    class BottomHeight(val bottom: Int, val height: Int): VerticalConstraint(Constraint.Vertical.BottomHeight)





}