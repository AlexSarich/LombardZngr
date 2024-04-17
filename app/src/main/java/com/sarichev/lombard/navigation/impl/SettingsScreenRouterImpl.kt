package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.loanslist.getLoansListScreen
import com.sarichev.lombard.feature.loans.login.getLoginScreen
import com.sarichev.lombard.feature.loans.settings.SettingsScreenRouter
import javax.inject.Inject

class SettingsScreenRouterImpl @Inject constructor(
    private val router: Router
) : SettingsScreenRouter {

    override fun openLogInScreen() {
        router.newRootScreen(getLoginScreen())
    }

    override fun openLoansListScreen() {
        router.backTo(getLoansListScreen())
    }
}