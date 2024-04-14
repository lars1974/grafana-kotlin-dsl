package folder

import AbstractGrafanaObject

class Folder(): AbstractGrafanaObject(){

    constructor(folder: Folder.() -> Unit) : this() {
        this.apply(folder)
    }

    fun uid(uid: String) = field("uid",uid)
    fun title(title: String) = field("title", title)
    fun parentUid(parentUid: String) = field("parentUid", parentUid)
    fun overwrite(overwrite: Boolean) = field("overwrite", overwrite)
}