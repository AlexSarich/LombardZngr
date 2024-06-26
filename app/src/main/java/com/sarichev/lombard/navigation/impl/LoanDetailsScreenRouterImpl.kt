package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loandetails.LoanDetailsScreenRouter
import com.sarichev.lombard.feature.loans.loanslist.getLoansListScreen
import javax.inject.Inject

class LoanDetailsScreenRouterImpl @Inject constructor(
    private val router: Router
) : LoanDetailsScreenRouter {
    override fun openLoansListScreen() {
        router.backTo(getLoansListScreen())
    }
}