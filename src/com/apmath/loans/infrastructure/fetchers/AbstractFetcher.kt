package com.apmath.loans.infrastructure.fetchers

import io.ktor.client.HttpClient
import io.ktor.client.engine.apache.Apache
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.put

open class AbstractFetcher(
    var host: Host,
    testing: Boolean = false
) {
    init {
        if (testing)
            host = Host.JSON_PLACE_HOLDER
    }

    suspend inline fun <reified T> get(path: String): T {
        return AbstractFetcher.client.get(
            host = host.value,
            path = path
        )
    }

    suspend inline fun <reified T> post(path: String, body: Any): T {
        return AbstractFetcher.client.post(
            host = host.value,
            path = path,
            body = body
        )
    }

    suspend inline fun <reified T> put(path: String, body: Any): T {
        return AbstractFetcher.client.put(
            host = host.value,
            path = path,
            body = body
        )
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
