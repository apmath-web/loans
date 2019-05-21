package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.data.Money

class WrongAmountException(val min: Money, val max: Money) : Exception()
