package com.apmath.loans.domain.models

interface MixedIdInterface {
    val isClient: Boolean
    val clientIdHeader: Int?
    val clientId: Int?
}
