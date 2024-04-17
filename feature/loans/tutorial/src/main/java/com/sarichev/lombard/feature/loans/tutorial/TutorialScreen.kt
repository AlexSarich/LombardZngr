package com.sarichev.lombard.feature.loans.tutorial

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.tutorial.ui.TutorialFragment

fun getTutorialScreen(): FragmentScreen =
    FragmentScreen { TutorialFragment.newInstance() }