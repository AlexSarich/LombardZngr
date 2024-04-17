package com.sarichev.lombard.feature.loans.registration

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.registration.ui.RegistrationFragment

fun getRegistrationScreen(): FragmentScreen =
    FragmentScreen { RegistrationFragment.newInstance() }