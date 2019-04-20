package com.apmath.loans.application.v1

import com.apmath.loans.application.v1.actions.v1Create
import com.apmath.loans.application.v1.actions.v1Info
import com.apmath.loans.domain.services.LoanServiceInterface
import io.ktor.application.call
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import org.koin.ktor.ext.inject

internal fun Routing.v1() {

    v1Info()
    // other route groups here
}

private fun Routing.v1Info() {
    val loanService: LoanServiceInterface by inject()

    route("v1") {
        get("info") {
            call.v1Info()
        }
        post("loan") {
            call.v1Create(loanService)
        }
    }
}
