package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

class NoClientException : ApiException("Client does not exist", HttpStatusCode.BadRequest)
