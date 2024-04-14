package dashboard.panel.panels.text

import AbstractGrafanaObject

class Code: AbstractGrafanaObject() {

    fun language(language: String) = field("language", language)
    fun showLineNumbers(showLineNumbers: Boolean) = field("showLineNumbers", showLineNumbers)
    fun showMiniMap(showMiniMap: Boolean) = field("showMiniMap", showMiniMap)
}