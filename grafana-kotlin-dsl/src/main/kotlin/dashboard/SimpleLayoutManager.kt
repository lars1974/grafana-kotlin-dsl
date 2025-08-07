package dashboard

import dashboard.panel.common.GridPos

class SimpleLayoutManager() {
    var lmPos = GridPos.Position(0, 0, 0, 0)

    var currentWith = 0
    var currentHeight = 0


    var x = 0
    var y = 0
    var w = 0
    var h = 0

    constructor(w: Int, h: Int): this() {
        this.w = w
        this.h = h
    }

    constructor(lmPos: GridPos.Position, w: Int, h: Int): this() {
        this.lmPos = lmPos
        this.x = lmPos.x
        this.y = lmPos.y
        this.w = w
        this.h = h
    }

    fun next(): GridPos.Position = next(this.currentWith, this.currentHeight)

    fun next(w: Int, h: Int): GridPos.Position{
        if(this.x + w > lmPos.x + lmPos.w) this.x = lmPos.x
        val pos = GridPos.Position(x, y, w, h)
        this.x += w
        this.y += h
        this.w = w
        this.h = h

        println("x: ${pos.x}, y: ${pos.y}, w: ${pos.w}, h: ${pos.h}")
        return pos
    }
}