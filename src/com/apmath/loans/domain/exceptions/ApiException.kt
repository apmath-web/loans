package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

open class ApiException(
    override val message: String,
    val code: HttpStatusCode
) : Exception(message)
