package com.apmath.loans.domain.models.loans

import com.apmath.loans.domain.models.data.Currency
import com.apmath.loans.domain.models.data.Money

data class LoanCreationData(
    override val clientId: Int,
    override val applicationId: Int,

    override val amount: Money,
    override val term: Int,
    override val currency: Currency,
    override val date: String
) : LoanCreationDataInterface
