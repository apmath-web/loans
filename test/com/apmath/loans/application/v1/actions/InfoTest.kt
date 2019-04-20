package com.apmath.loans.application.v1.actions

import com.apmath.loans.module
import io.ktor.http.*
import io.ktor.locations.KtorExperimentalLocationsAPI
import kotlin.test.*
import io.ktor.server.testing.*

class InfoTest {
    @KtorExperimentalLocationsAPI
    @Test
    fun testInfo() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/v1/info").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("{\"version\":\"0.0.1\"}", response.content)
            }
        }
    }
}
