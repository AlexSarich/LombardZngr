package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loancreated.LoanCreatedScreenRouter
import javax.inject.Inject

class LoanCreatedScreenRouterImpl @Inject constructor(
    private val router: Router
) : LoanCreatedScreenRouter {
    override fun openLoansListScreen() {
        router.exit()
    }
}