package com.apmath.loans

import com.apmath.loans.application.v1.v1
import com.apmath.loans.com.apmath.loans.infrastructure.ServiceManager
import com.apmath.loans.com.apmath.loans.infrastructure.ServiceManager.Companion.serviceManagerModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.routing.Routing
import org.koin.Logger.slf4jLogger
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@KtorExperimentalLocationsAPI
@Suppress("UNUSED_PARAMETER") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(Locations) {
    }

    install(DefaultHeaders) {
    }

    install(Koin) {
        slf4jLogger()
        modules(serviceManagerModule)
        ServiceManager.init(this@module)
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    install(Routing) {
        // append routing from application here
        v1()
    }
}
