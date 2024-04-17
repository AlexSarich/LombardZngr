package com.sarichev.lombard.feature.loans.newloan

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.newloan.ui.NewLoanFragment

fun getNewLoanScreen(): FragmentScreen =
    FragmentScreen { NewLoanFragment.newInstance() }