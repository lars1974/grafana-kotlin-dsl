import org.junit.jupiter.api.Test
import dashboard.panel.Panel
import dashboard.panel.PanelTemplates
import java.io.File


class DefaultPanelTest {
    @Test
    fun test() {
        val expected = File("src/test/resources/default-panel.json").readText()

        val p = Panel {
            mixin(PanelTemplates.createTimeSeriesDefault())
        }
    }


}