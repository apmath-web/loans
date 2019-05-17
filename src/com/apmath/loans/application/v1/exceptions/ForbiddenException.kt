package com.apmath.loans.application.v1.exceptions

import io.ktor.http.HttpStatusCode

class ForbiddenException(message: String) : ApiException(message, HttpStatusCode.Forbidden)
