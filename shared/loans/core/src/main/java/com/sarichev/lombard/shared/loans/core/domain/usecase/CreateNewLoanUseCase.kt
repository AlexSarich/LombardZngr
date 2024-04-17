package com.sarichev.lombard.shared.loans.core.domain.usecase

import com.sarichev.lombard.shared.loans.core.domain.entity.LoanRequest
import com.sarichev.lombard.shared.loans.core.domain.repository.LoanRepository
import javax.inject.Inject

class CreateNewLoanUseCase @Inject constructor(private val repository: LoanRepository) {

    suspend operator fun invoke(loanRequest: LoanRequest) =
        repository.createNewLoan(loanRequest)
}