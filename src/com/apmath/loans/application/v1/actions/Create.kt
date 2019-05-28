package com.apmath.loans.application.v1.actions

import com.apmath.loans.application.v1.exceptions.BadRequestException
import com.apmath.loans.application.v1.exceptions.BadRequestValidationException
import com.apmath.loans.application.v1.exceptions.NotFoundException
import com.apmath.loans.application.v1.models.incoming.Loan
import com.apmath.loans.application.v1.models.incoming.toLoanClient
import com.apmath.loans.application.v1.validators.LoanBuilder
import com.apmath.loans.domain.exceptions.NoClientException
import com.apmath.loans.domain.exceptions.NotApprovedException
import com.apmath.loans.domain.exceptions.WrongAmountException
import com.apmath.loans.domain.exceptions.WrongClientId
import com.apmath.loans.domain.services.LoanServiceInterface
import com.apmath.validation.simple.RequiredValidator
import io.ktor.application.ApplicationCall
import io.ktor.client.features.BadResponseStatusException
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond

suspend fun ApplicationCall.v1Create(loanService: LoanServiceInterface) {
    val loan = receive<Loan>()
    loan.clientId = getUserId(request)

    val validator = LoanBuilder()
        .prepend("clientId", RequiredValidator())
        .prepend("applicationId", RequiredValidator())
        .prepend("amount", RequiredValidator())
        .prepend("currency", RequiredValidator())
        .prepend("term", RequiredValidator())
        .prepend("date", RequiredValidator())
        .build()

    if (!validator.validate(loan)) {
        throw BadRequestValidationException(validator)
    }

    val loanDomain = loan.toLoanClient()
    val loanId: Int =
        try {
            loanService.add(loanDomain)
        } catch (e: NoClientException) {
            throw NotFoundException("Client does not exist")
        } catch (e: NotApprovedException) {
            throw BadRequestException("Application not approved, currently is ${e.status}")
        } catch (e: WrongClientId) {
            throw BadRequestException("Wrong client")
        } catch (e: WrongAmountException) {
            throw BadRequestException("Loan's amount must be bigger than ${e.min} and less than ${e.max}")
        } catch (e: BadResponseStatusException) {
            when(e.statusCode) {
                HttpStatusCode.BadRequest   -> throw BadRequestException(e.localizedMessage)
                HttpStatusCode.NotFound     -> throw NotFoundException(e.localizedMessage)
                else                        -> throw e
            }
        }

    respond(mapOf("loanId" to loanId))
}
