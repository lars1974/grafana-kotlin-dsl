# grafana-kotlin-dsl

Create Grafana Dashboards using Kotlin DSL
```kotlin
val publisher = GrafanaPublisher("http://localhost:3000", "admin:test", GrafanaPublisher.AuthType.Basic)

publisher.publish(DashBoardWrapper {
    dashboard("My First Dashboard") {
        panels {
            timeseries("My First Panel") {
                position(0, 0, 12, 12)
            }
        }
    }
})
```

If you prefer Java, you can use the following code:
```java
public void createDashboard(){
    
    var publisher = new GrafanaPublisher("http://localhost:3000", "admin:test", GrafanaPublisher.AuthType.Basic);

    publisher.publish(new DashBoardWrapper(wrapper -> {
        wrapper.dashboard("My first Dashboard", dashboard -> {
            dashboard.panels(panels -> {
                panels.timeseries("My first Panel", timeseriesPanel -> {
                    timeseriesPanel.position(0,0,12,12, gridPos -> Unit.INSTANCE);
                    return Unit.INSTANCE;
                });
                return Unit.INSTANCE;
            });
            return Unit.INSTANCE;
        });
        return Unit.INSTANCE;
    }));
}
```