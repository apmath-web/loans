package com.apmath.loans.domain.models.connections.request

import com.apmath.loans.domain.models.data.Money

class LastPayment(override val date: String,
                  override val amount: Money,
                  override val remainCreditBody: Money
) : LastPaymentInterface {
}
