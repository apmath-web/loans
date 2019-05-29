package com.apmath.loans

import com.apmath.loans.application.v1.exceptions.ApiException
import com.apmath.loans.application.v1.respondApiException
import com.apmath.loans.application.v1.v1
import com.apmath.loans.infrastructure.loans
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
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
import java.time.LocalDate
import java.time.format.DateTimeFormatter

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
            registerTypeAdapter(LocalDate::class.java, object: TypeAdapter<LocalDate>() {
                val format = DateTimeFormatter.ISO_DATE

                override fun write(out: JsonWriter, value: LocalDate) {
                    out.value(format.format(value))
                }

                override fun read(input: JsonReader): LocalDate
                        = LocalDate.parse(input.nextString(),format)

            })
            if (!testing) {
                setPrettyPrinting()
            }
        }
    }

    install(Routing) {
        // append routing from application here
        v1()
    }
}
