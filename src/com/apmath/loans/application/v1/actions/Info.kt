package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.models.Info
import io.ktor.application.ApplicationCall
import io.ktor.request.receive
import io.ktor.response.respond
import sun.util.resources.LocaleData
import java.util.*

suspend fun ApplicationCall.v1Info() {
    respond(Info(Calendar.getInstance().time))
}

suspend fun ApplicationCall.v1InfoPost() {
    val req = receive<Req>()
    println(req)
    println(req.date.time)
    respond(req)
}

data class Req(val id: Int, val date: Date)
