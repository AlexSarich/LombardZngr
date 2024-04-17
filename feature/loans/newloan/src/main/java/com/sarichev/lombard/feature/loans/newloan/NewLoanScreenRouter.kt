package com.sarichev.lombard.feature.loans.newloan

import com.sarichev.lombard.shared.loans.core.domain.entity.Loan

interface NewLoanScreenRouter {

    fun openLoanCreatedScreen(loan: Loan)
}