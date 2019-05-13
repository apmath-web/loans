package com.apmath.loans.infrastructure.fetchers

enum class Host(val value: String) {
    CLIENTS(fromEnv("CLIENTS_PORT")),
    APPLICATIONS(fromEnv("APPLICATIONS_PORT")),
    CALCULATIONS(fromEnv("CALCULATIONS_PORT"))
}

private fun fromEnv(key: String): String {
    return System.getenv(key).let {
         when (it) {
            null    -> throw NullPointerException("Missing environment value for $key")
            "mock"  -> mock
            else    -> "$it:$port"
        }
    }
}

private const val port = "8080"
private const val mock = "demo5033957.mockable.io"
