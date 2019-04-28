package com.apmath.loans.infrastructure.fetchers

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

//TODO: temporary implementation
open class AbstractFetcher(
    val host: Host
) {
    suspend inline fun <reified T> get(path: String): T {
        return AbstractFetcher.client.request {
            method = HttpMethod.Get
            url(
                host = host.value,
                path = path
            )
        }
    }

    suspend inline fun <reified T> post(path: String, bodyReq: Any): T {
        return AbstractFetcher.client.request {
            method = HttpMethod.Post
            url(
                host = host.value,
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
                host = host.value,
                path = path
            )
            body = bodyReq
            contentType(ContentType.Application.Json)
        }
    }

    suspend inline fun isSuccess(path: String): Boolean {
        return AbstractFetcher.client.call {
            url(
                host = host.value,
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
                }
            }
        }
    }
}
