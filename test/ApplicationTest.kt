package com.apmath.loans

import io.ktor.http.*
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.*
import kotlin.test.*
import io.ktor.client.engine.mock.*
import kotlinx.coroutines.io.*
import io.ktor.client.call.*

class ApplicationTest {

    // TODO example of complex test with client mock
    fun testClientMock() {
        runBlocking {
            val client = HttpClient(MockEngine {
                if (url.encodedPath == "/") {
                    MockHttpResponse(call, HttpStatusCode.OK, ByteReadChannel(byteArrayOf(1, 2, 3)), headersOf("X-MyHeader", "MyValue"))
                } else {
                    responseError(HttpStatusCode.NotFound, "Not Found ${url.encodedPath}")
                }
            }) {
                expectSuccess = false
            }
            assertEquals(byteArrayOf(1, 2, 3).toList(), client.get<ByteArray>("/").toList())
            assertEquals("MyValue", client.call("/").response.headers["X-MyHeader"])
            assertEquals("Not Found other/path", client.get<String>("/other/path"))
        }
    }
}
