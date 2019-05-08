package com.apmath.loans.application.v1.models.response

import com.apmath.loans.domain.models.loans.LoanInterface

@Suppress("ArrayInDataClass")
data class ListLoansResponse(val loans: Array<LoanInterface>)
