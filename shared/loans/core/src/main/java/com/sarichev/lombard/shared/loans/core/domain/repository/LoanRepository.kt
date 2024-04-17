package com.sarichev.lombard.shared.loans.core.domain.repository

import com.sarichev.lombard.shared.loans.core.domain.entity.AuthInfo
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan
import com.sarichev.lombard.shared.loans.core.domain.entity.LoanConditions
import com.sarichev.lombard.shared.loans.core.domain.entity.LoanRequest
import com.sarichev.lombard.shared.loans.core.domain.entity.result.RequestResult

interface LoanRepository {

    suspend fun register(authInfo: AuthInfo): RequestResult<Unit>

    fun checkIfLoggedIn(): Boolean

    suspend fun logIn(authInfo: AuthInfo): RequestResult<Unit>

    suspend fun logOut(): Boolean

    suspend fun getLoanConditions(): RequestResult<LoanConditions>

    suspend fun createNewLoan(loanRequest: LoanRequest): RequestResult<Loan>

    suspend fun getAllLoans(): RequestResult<List<Loan>>
}