package com.sarichev.lombard.feature.loans.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarichev.lombard.feature.loans.settings.SettingsScreenRouter
import com.sarichev.lombard.shared.loans.core.domain.usecase.LogOutUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase,
    private val router: SettingsScreenRouter
) : ViewModel() {

    fun logOut() {
        viewModelScope.launch {
            val loggedOut = logOutUseCase()
            if (loggedOut) {
                router.openLogInScreen()
            } else throw RuntimeException("Can't log out")
        }
    }

    fun openLoansListScreen() {
        router.openLoansListScreen()
    }
}