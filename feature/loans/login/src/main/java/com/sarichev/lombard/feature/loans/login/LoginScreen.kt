package com.sarichev.lombard.feature.loans.login

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.login.ui.LoginFragment

fun getLoginScreen(): FragmentScreen =
    FragmentScreen { LoginFragment.newInstance() }