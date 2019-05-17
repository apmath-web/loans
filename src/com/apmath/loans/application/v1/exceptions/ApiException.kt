package com.apmath.loans.application.v1.exceptions

import io.ktor.http.HttpStatusCode

abstract class ApiException(
    message: String,
    val code: HttpStatusCode
) : Exception(message)
