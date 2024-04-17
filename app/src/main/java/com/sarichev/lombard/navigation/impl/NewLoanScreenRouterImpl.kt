package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loancreated.getLoanCreatedScreen
import com.sarichev.lombard.feature.loans.loanslist.getLoansListScreen
import com.sarichev.lombard.feature.loans.newloan.NewLoanScreenRouter
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan
import javax.inject.Inject

class NewLoanScreenRouterImpl @Inject constructor(
    private val router: Router
) : NewLoanScreenRouter {
    override fun openLoanCreatedScreen(loan: Loan) {
        router.newRootChain(getLoansListScreen(), getLoanCreatedScreen(loan))
    }
}