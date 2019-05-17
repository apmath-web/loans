package com.apmath.loans.application.v1.models.incoming

data class LoansListRequest(
    var clientIdHeader: Int?,
    var isService: Boolean,
    var clientId: Int?
)
