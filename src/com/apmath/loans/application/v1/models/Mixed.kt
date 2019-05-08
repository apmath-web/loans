package com.apmath.loans.application.v1.models

import com.apmath.loans.domain.models.MixedId
import com.apmath.loans.infrastructure.fetchers.Host

data class Mixed(
    var clientIdHeader: Int?,
    var serviceIdHeader: String?,
    var clientId: String?
)

fun Mixed.toMixedId() = MixedId(
    when (serviceIdHeader) {
        //TODO Rewrite with id or add all hosts
        Host.APPLICATIONS.value, Host.CALCULATIONS.value, Host.CLIENTS.value    -> false
        else                                                                    -> true
    },
    clientIdHeader,
    clientId?.toInt()!!
)
