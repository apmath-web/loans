package com.apmath.loans

import com.apmath.loans.application.v1.v1
import io.ktor.application.*
import io.ktor.routing.*
import io.ktor.locations.*
import io.ktor.features.*
import io.ktor.gson.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("UNUSED_PARAMETER") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(Locations) {
    }

    install(DefaultHeaders) {
    }

    install(ContentNegotiation) {
        gson {
            setDateFormat("yyyy-mm-dd")
            setPrettyPrinting()
        }
    }

    install(Routing) {
        // append routing from application here
        v1()
    }
}
