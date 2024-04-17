package com.sarichev.lombard.feature.loans.loanslist

import com.sarichev.lombard.shared.loans.core.domain.entity.Loan

interface LoansListScreenRouter {

    fun openLoanDetailsScreen(loan: Loan)

    fun openCreateLoanScreen()

    fun openSettings()
}