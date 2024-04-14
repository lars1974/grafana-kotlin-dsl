package dashboard.panel.common

import AbstractGrafanaObject

class GridPos(): AbstractGrafanaObject() {
    constructor(pos: Position) : this() {
        x(pos.x)
        y(pos.y)
        w(pos.w)
        h(pos.h)
    }

    constructor(x: Int, y: Int, w: Int, h: Int) : this() {
        x(x)
        y(y)
        w(w)
        h(h)
    }

    fun x(x: Int) = field("x", x)

    fun y(y: Int) = field("y", y)

    fun w(w: Int) = field("w", w)

    fun h(h: Int) = field("h", h)

    class Position(val x: Int, val y: Int, val w: Int, val h: Int)
}