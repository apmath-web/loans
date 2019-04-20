package com.apmath.loans.infrastructure.fetchers

enum class Host(val value: String) {
    CLIENTS("localhost:8080"),
    APPLICATIONS("localhost:8081"),
    CALCULATIONS("localhost:8082"),
    TESTING_PLACE_HOLDER("demo5033957.mockable.io");
}
