package com.apmath.loans.infrastructure.fetchers

import com.typesafe.config.ConfigFactory
import io.ktor.config.HoconApplicationConfig

enum class Host(val value: String) {
    CLIENTS(host("clients")),
    APPLICATIONS(host("applications")),
    CALCULATIONS(host("calculations")),
}

private fun host(name: String): String {
    val config = HoconApplicationConfig(ConfigFactory.load())

    return if (config.property("$name.testing").getString() == "true")
        config.property("$name.domain").getString()
    else
        config.property("mock.domain").getString()
}
