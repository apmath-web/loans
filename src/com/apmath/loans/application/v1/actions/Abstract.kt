package com.apmath.loans.application.v1.actions

import com.apmath.loans.infrastructure.fetchers.Host
import com.apmath.validation.simple.Message
import io.ktor.response.respond
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
            Host.APPLICATIONS.value, Host.CALCULATIONS.value, Host.CLIENTS.value    -> true
            else                                                                    -> false
        }
    }

    return false
}

fun getLoanId(request: ApplicationRequest): Int? {

    val loanHeaderKey = "loanId"

    if (request.headers.contains(loanHeaderKey)) {
        try {
            return request.headers[loanHeaderKey]?.toInt()
        } catch (e: NumberFormatException) {

        }
    }

    return null
}

//TODO: redo with suitable integer validator
fun getAndValidateId(parameterId: String): Int? {

    try {
        return parameterId.toInt()
    } catch (e: NumberFormatException) {

    }

    return null
}
