package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loanslist.getLoansListScreen
import com.sarichev.lombard.feature.loans.tutorial.TutorialScreenRouter
import javax.inject.Inject

class TutorialScreenRouterImpl @Inject constructor(
    private val router: Router
) : TutorialScreenRouter {

    override fun openLoansListScreen() {
        router.newRootScreen(getLoansListScreen())
    }
}