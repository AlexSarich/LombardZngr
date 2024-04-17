package com.sarichev.lombard.feature.loans.settings

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.settings.ui.SettingsFragment

fun getSettingsScreen() =
    FragmentScreen { SettingsFragment.newInstance() }