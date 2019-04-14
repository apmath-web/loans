package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Info
import io.ktor.application.ApplicationCall
import io.ktor.response.respond

suspend fun ApplicationCall.v1Info() {
    respond(Info("0.0.1"))
}
