package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loandetails.getLoanDetailsScreen
import com.sarichev.lombard.feature.loans.loanslist.LoansListScreenRouter
import com.sarichev.lombard.feature.loans.newloan.getNewLoanScreen
import com.sarichev.lombard.feature.loans.settings.getSettingsScreen
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan
import javax.inject.Inject

class LoansListScreenRouterImpl @Inject constructor(
    private val router: Router
) : LoansListScreenRouter {
    override fun openLoanDetailsScreen(loan: Loan) {
        router.navigateTo(getLoanDetailsScreen(loan))
    }

    override fun openCreateLoanScreen() {
        router.navigateTo(getNewLoanScreen())
    }

    override fun openSettings() {
        router.navigateTo(getSettingsScreen())
    }
}