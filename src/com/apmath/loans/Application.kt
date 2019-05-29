package com.apmath.loans

import com.apmath.loans.application.v1.exceptions.ApiException
import com.apmath.loans.application.v1.respondApiException
import com.apmath.loans.application.v1.v1
import com.apmath.loans.infrastructure.loans
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.features.StatusPages
import io.ktor.gson.gson
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.routing.Routing
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("UNUSED_PARAMETER") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(StatusPages) {
        exception<ApiException> { e ->
            call.respondApiException(e)
        }
    }

    install(DefaultHeaders) {
    }

    install(Koin) {
        slf4jLogger()
        properties(mapOf("config" to environment.config))
        modules(loans)
    }

    install(ContentNegotiation) {
        gson {
            if (!testing)
                setPrettyPrinting()
        }
    }

    install(Routing) {
        // append routing from application here
        v1()
    }
}
