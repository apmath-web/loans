package com.apmath.loans.application.v1.exceptions

import java.lang.Exception

class BadServiceResponse(val code: Int, message: String) : Exception(message)
