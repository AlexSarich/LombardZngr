package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.login.getLoginScreen
import com.sarichev.lombard.feature.loans.registration.RegistrationScreenRouter
import javax.inject.Inject


class RegistrationScreenRouterImpl @Inject constructor(
    private val router: Router
) : RegistrationScreenRouter {
    override fun openLogInScreen() =
        router.backTo(getLoginScreen())
}