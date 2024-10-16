package dashboard.dashboard

import AbstractGrafanaArray

class Links() : AbstractGrafanaArray() {




    fun link(link: Link.() -> Unit) = add(Link().apply(link))
}