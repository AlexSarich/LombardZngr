package com.sarichev.lombard.feature.loans.loandetails.presentation

import androidx.lifecycle.ViewModel
import com.sarichev.lombard.feature.loans.loandetails.LoanDetailsScreenRouter
import javax.inject.Inject

class LoanDetailsViewModel @Inject constructor(
    private val router: LoanDetailsScreenRouter
) : ViewModel() {

    fun openLoansListScreen() {
        router.openLoansListScreen()
    }

}