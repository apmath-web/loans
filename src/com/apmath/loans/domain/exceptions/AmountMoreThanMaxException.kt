package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.models.data.Money
import io.ktor.http.HttpStatusCode

class AmountMoreThanMaxException(amount: Money, maxAmount: Money) :
    ApiException("Loan's amount = $amount is bigger than max possible amount = $maxAmount", HttpStatusCode.BadRequest)
