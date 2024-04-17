package com.sarichev.lombard.feature.loans.loancreated.presentation

import androidx.lifecycle.ViewModel
import com.sarichev.lombard.feature.loans.loancreated.LoanCreatedScreenRouter
import javax.inject.Inject

class LoanCreatedViewModel @Inject constructor(
    private val router: LoanCreatedScreenRouter
) : ViewModel() {

    fun openLoansListScreen() {
        router.openLoansListScreen()
    }
}