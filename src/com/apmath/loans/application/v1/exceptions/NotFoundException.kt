package com.apmath.loans.application.v1.exceptions

import io.ktor.http.HttpStatusCode

class NotFoundException(message: String) : ApiException(message, HttpStatusCode.NotFound)
