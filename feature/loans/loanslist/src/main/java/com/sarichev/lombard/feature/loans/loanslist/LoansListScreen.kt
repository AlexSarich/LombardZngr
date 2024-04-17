package com.sarichev.lombard.feature.loans.loanslist

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.loanslist.ui.LoansListFragment

fun getLoansListScreen(): FragmentScreen =
    FragmentScreen { LoansListFragment.newInstance() }