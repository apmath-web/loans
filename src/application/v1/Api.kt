package com.apmath.loans.application.v1

import com.apmath.loans.application.v1.actions.v1Create
import com.apmath.loans.application.v1.actions.v1Info
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

internal fun Routing.v1() {

    v1Info()
    // other route groups here
}

private fun Routing.v1Info() {

    route("v1") {
        get("info") {
            call.v1Info()
        }
        post {
            call.v1Create()
        }
    }
}
