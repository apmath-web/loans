package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.data.Money
import io.ktor.http.HttpStatusCode

class WrongAmountException(min: Money, max: Money) :
    ApiException("Loan's amount must be bigger than $min and less than $max", HttpStatusCode.BadRequest)
