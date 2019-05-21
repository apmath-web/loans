package com.apmath.loans.domain.exceptions

import com.apmath.loans.domain.data.Status

class NotApprovedException(val status: Status) : Exception()
