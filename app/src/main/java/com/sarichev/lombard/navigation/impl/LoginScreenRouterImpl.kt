package com.sarichev.lombard.navigation.impl

import com.github.terrakok.cicerone.Router
import com.sarichev.lombard.feature.loans.login.LoginScreenRouter
import com.sarichev.lombard.feature.loans.registration.getRegistrationScreen
import com.sarichev.lombard.feature.loans.tutorial.getTutorialScreen
import javax.inject.Inject

class LoginScreenRouterImpl @Inject constructor(
    private val router: Router
) : LoginScreenRouter {
    override fun openTutorialScreen() {
        router.newRootScreen(getTutorialScreen())
    }

    override fun openRegistrationScreen() =
        router.navigateTo(getRegistrationScreen())
}