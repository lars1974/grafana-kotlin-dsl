package org.example;

import client.GrafanaPublisher;
import dashboard.DashBoardWrapper;
import kotlin.Unit;

public class Main {
    public static void main(String[] args) {
        GrafanaPublisher publisher = new GrafanaPublisher("http://localhost:3000", "admin:test", GrafanaPublisher.AuthType.Basic);

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
}