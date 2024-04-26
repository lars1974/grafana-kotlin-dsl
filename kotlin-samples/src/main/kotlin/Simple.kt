package org.example

import client.GrafanaPublisher
import dashboard.DashboardWithContext

fun main() {
    val publisher = GrafanaPublisher("http://localhost:3000", "admin:password", GrafanaPublisher.AuthType.Basic)

    publisher.publish(DashboardWithContext {
        dashboard("My First Dashboard") {
            panels {
                timeseries("My First Panel") {
                    position(0, 0, 12, 12)
                }
            }
        }
    })

}