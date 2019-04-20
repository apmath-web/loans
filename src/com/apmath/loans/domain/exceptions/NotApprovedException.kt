package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.models.data.Status
import io.ktor.http.HttpStatusCode

class NotApprovedException(status: Status) :
    ApiException("Application not approved, currently is $status", HttpStatusCode.BadRequest)
