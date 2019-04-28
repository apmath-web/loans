package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

class WrongClientId : ApiException("Wrong client", HttpStatusCode.BadRequest)
