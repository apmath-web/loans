package com.apmath.loans.domain.models

data class MixedLoanId(
    override val isClient: Boolean,
    override val loanIdHeader: Int?,
    override val loanId: Int?
) : MixedLoanIdInterface
