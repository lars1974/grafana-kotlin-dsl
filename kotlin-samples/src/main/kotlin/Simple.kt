package org.example

import client.GrafanaPublisher
import dashboard.DashBoardWrapper

fun main() {
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

}