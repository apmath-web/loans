package com.apmath.loans.infrastructure.fetchers

enum class Host(val value: String) {
    CLIENTS("localhost:8080"),
    APPLICATIONS("localhost:8081"),
    CALCULATIONS("localhost:8082"),
    JSON_PLACE_HOLDER("my-json-server.typicode.com");
}
