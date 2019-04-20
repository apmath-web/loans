package com.apmath.loans.domain.exceptions

import io.ktor.http.HttpStatusCode

class NoClientException(id: Int) : ApiException("Client with id = $id does not exist", HttpStatusCode.BadRequest)
