package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

class ForbiddenAccessException :
    ApiException("Permission denied", HttpStatusCode.Forbidden)
