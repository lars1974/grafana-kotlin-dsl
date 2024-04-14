package dashboard.panel.common

import AbstractGrafanaObject

class Link(): AbstractGrafanaObject() {
    constructor(title: String, url: String, targetBlank: Boolean): this(){
        targetBlank(targetBlank)
        title(title)
        url(url)
    }

    fun targetBlank(targetBlank: Boolean) = field("targetBlank", targetBlank)
    fun title(title: String) = field("title", title)
    fun url(url: String) = field("url", url)
}