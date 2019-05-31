package com.apmath.loans.infrastructure.fetchers

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import io.ktor.client.HttpClient
import io.ktor.client.call.call
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.request
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import java.time.LocalDate
import java.time.format.DateTimeFormatter

//TODO: temporary implementation
open class AbstractFetcher(val host: String, val port: Int) {
    suspend inline fun <reified T> get(path: String): T {
        return AbstractFetcher.client.request {
            method = HttpMethod.Get
            url(
                host = host,
                port = port,
                path = path
            )
        }
    }

    suspend inline fun <reified T> post(path: String, bodyReq: Any): T {
        return AbstractFetcher.client.request {
            method = HttpMethod.Post
            url(
                host = host,
                port = port,
                path = path
            )
            body = bodyReq
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun <reified T> put(path: String, bodyReq: Any): T {
        return AbstractFetcher.client.request {
            method = HttpMethod.Put
            url(
                host = host,
                port = port,
                path = path
            )
            body = bodyReq
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun isSuccess(path: String): Boolean {
        return AbstractFetcher.client.call {
            url(
                host = host,
                port = port,
                path = path
            )
        }.response.status.isSuccess()
    }

    companion object {
        val client: HttpClient = HttpClient(Apache) {
            install(JsonFeature) {
                serializer = GsonSerializer {
                    serializeNulls()
                    disableHtmlEscaping()
                    registerTypeAdapter(LocalDate::class.java, object: TypeAdapter<LocalDate>() {
                        val format = DateTimeFormatter.ISO_DATE

                        override fun write(out: JsonWriter, value: LocalDate) {
                            out.value(format.format(value))
                        }

                        override fun read(input: JsonReader): LocalDate
                                = LocalDate.parse(input.nextString(),format)

                    })
                }
            }
        }
    }
}
