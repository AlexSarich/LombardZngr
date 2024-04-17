package com.sarichev.lombard.shared.loans.core.domain.usecase

import com.sarichev.lombard.shared.loans.core.domain.entity.AuthInfo
import com.sarichev.lombard.shared.loans.core.domain.repository.LoanRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repository: LoanRepository) {

    suspend operator fun invoke(authInfo: AuthInfo) =
        repository.register(authInfo)
}