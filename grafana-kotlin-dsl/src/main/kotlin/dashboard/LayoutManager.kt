package dashboard

import dashboard.panel.common.GridPos

class LayoutManager() {
    var x = 0
    var y = 0
    var w = 0
    var h = 0

    constructor(w: Int, h: Int): this() {
        this.w = w
        this.h = h
    }

    fun next(): GridPos.Position = next(this.w, this.h)

    fun next(w: Int, h: Int): GridPos.Position{
        if(this.x + w > 24) this.x = 0
        val pos = GridPos.Position(x, y, w, h)
        this.x += w
        this.y += h
        this.w = w
        this.h = h

        return pos
    }
}