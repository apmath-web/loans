package com.apmath.loans.domain.services

import com.apmath.loans.domain.models.MixedIdInterface
import com.apmath.loans.domain.models.loans.LoanCreationDataInterface
import com.apmath.loans.domain.models.loans.LoanInterface

interface LoanServiceInterface {
    suspend fun add(loan: LoanCreationDataInterface) : Int
    suspend fun get(mixedId: MixedIdInterface) : Array<LoanInterface>
}
