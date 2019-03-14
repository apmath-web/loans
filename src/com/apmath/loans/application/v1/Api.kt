package com.apmath.loans.application.v1

import com.apmath.loans.application.v1.actions.v1Info
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

internal fun Routing.v1() {
    v1Info()
}

private fun Routing.v1Info() {

    route("v1") {
        get("info") {
            call.v1Info()
        }
    }
}
