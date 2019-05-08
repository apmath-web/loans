package com.apmath.loans.domain.models

data class MixedId(
    override val isClient: Boolean,
    override val clientIdHeader: Int?,
    override val clientId: Int?
) : MixedIdInterface
