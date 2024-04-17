package com.sarichev.lombard.shared.loans.core.domain.usecase

import com.sarichev.lombard.shared.loans.core.domain.repository.LoanRepository
import javax.inject.Inject

class GetAllLoansUseCase @Inject constructor(private val repository: LoanRepository) {

    suspend operator fun invoke() =
        repository.getAllLoans()
}