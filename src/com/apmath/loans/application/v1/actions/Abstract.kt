package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestException
import com.apmath.loans.infrastructure.fetchers.Host
import io.ktor.application.ApplicationCall
import io.ktor.request.ApplicationRequest

fun getUserId(request: ApplicationRequest): Int? {

    val userHeaderKey = "clientId"

    if (request.headers.contains(userHeaderKey)) {
        try {
            return request.headers[userHeaderKey]?.toInt()
        } catch (e: NumberFormatException) {

        }
    }

    return null
}

fun isService(request: ApplicationRequest): Boolean {

    val serviceHeaderKey = "service"

    if (request.headers.contains(serviceHeaderKey)) {
        return when (request.headers[serviceHeaderKey]) {
            Host.APPLICATIONS.value, Host.CALCULATIONS.value, Host.CLIENTS.value -> true
            else -> false
        }
    }

    return false
}

// TODO validate via validator
fun getAndValidateClientId(clientIdParam: String?): Int? {

    if (clientIdParam == null) {
        return null
    }
    try {
        return clientIdParam.toInt()
    } catch (e: NumberFormatException) {
        throw BadRequestException("ClientId parameter must be numeric")
    }
}

// TODO validate via validator
fun getAndValidateLoanId(loanIdParam: String): Int {

    try {
        return loanIdParam.toInt()
    } catch (e: NumberFormatException) {
        throw BadRequestException("LoanId parameter must be numeric")
    }
}

fun ApplicationCall.getClientAttributeId(): String? {

    val userHeaderKey = "client"

    if (parameters.contains(userHeaderKey)) {
        return parameters[userHeaderKey]
    }

    return null
}
