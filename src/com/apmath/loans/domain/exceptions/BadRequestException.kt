package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

class BadRequestException :
    ApiException("Wrong arguments", HttpStatusCode.BadRequest)
