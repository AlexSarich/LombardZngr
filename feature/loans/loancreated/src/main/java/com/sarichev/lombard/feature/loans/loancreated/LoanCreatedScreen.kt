package com.sarichev.lombard.feature.loans.loancreated

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.loancreated.ui.LoanCreatedFragment
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan

fun getLoanCreatedScreen(loan: Loan) =
    FragmentScreen { LoanCreatedFragment.newInstance(loan) }