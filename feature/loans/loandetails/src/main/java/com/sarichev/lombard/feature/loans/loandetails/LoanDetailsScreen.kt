package com.sarichev.lombard.feature.loans.loandetails

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.sarichev.lombard.feature.loans.loandetails.ui.LoanDetailsFragment
import com.sarichev.lombard.shared.loans.core.domain.entity.Loan

fun getLoanDetailsScreen(loan: Loan) =
    FragmentScreen { LoanDetailsFragment.newInstance(loan) }