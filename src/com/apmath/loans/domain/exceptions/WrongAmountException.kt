package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.models.data.Money
import io.ktor.http.HttpStatusCode

class WrongAmountException(min: Money, max: Money) :
    ApiException("Loan's amount must be bigger than $max and less than $min", HttpStatusCode.BadRequest)
