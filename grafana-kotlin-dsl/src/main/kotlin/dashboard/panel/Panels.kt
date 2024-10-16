package dashboard.panel

import AbstractGrafanaArray
import dashboard.panel.panels.canvas.CanvasPanel
import dashboard.panel.panels.dashlist.DashlistPanel
import dashboard.panel.panels.gauge.GaugePanel
import dashboard.panel.panels.piechart.PiechartPanel
import dashboard.panel.panels.stat.StatPanel
import dashboard.panel.panels.table.TablePanel
import dashboard.panel.panels.text.TextPanel
import dashboard.panel.panels.timeseries.TimeseriesPanel


class Panels: AbstractGrafanaArray() {
    fun text(panel: TextPanel.() -> Unit) = add(TextPanel().apply(panel))
    fun gauge(panel: GaugePanel.() -> Unit) = add(GaugePanel().apply(panel))
    fun stat(panel: StatPanel.() -> Unit) = add(StatPanel().apply(panel))
    fun stat(title: String, panel: StatPanel.() -> Unit) = add(StatPanel().apply(panel).apply {title(title) })
    fun piechart(panel: PiechartPanel.() -> Unit) = add(PiechartPanel().apply(panel))

    fun timeseries(panel: TimeseriesPanel.() -> Unit) = add(TimeseriesPanel().apply(panel))
    fun timeseries(title: String, panel: TimeseriesPanel.() -> Unit) = add(TimeseriesPanel(title).apply(panel))
    fun canvas(panel: CanvasPanel.() -> Unit) = add(CanvasPanel().apply(panel))
    fun table(title: String, panel: TablePanel.() -> Unit) = add(TablePanel(title).apply(panel))
    fun dashlist(panel: DashlistPanel.() -> Unit) = add(DashlistPanel().apply(panel))
}