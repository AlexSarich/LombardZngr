package com.sarichev.lombard.di.module

import com.sarichev.lombard.feature.loans.loancreated.ui.LoanCreatedFragment
import com.sarichev.lombard.feature.loans.loandetails.ui.LoanDetailsFragment
import com.sarichev.lombard.feature.loans.loanslist.ui.LoansListFragment
import com.sarichev.lombard.feature.loans.login.ui.LoginFragment
import com.sarichev.lombard.feature.loans.newloan.ui.NewLoanFragment
import com.sarichev.lombard.feature.loans.registration.ui.RegistrationFragment
import com.sarichev.lombard.feature.loans.settings.ui.SettingsFragment
import com.sarichev.lombard.feature.loans.tutorial.ui.TutorialFragment
import com.sarichev.lombard.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ScreensModule {

    @ContributesAndroidInjector
    fun contributesMainActivityInjector(): MainActivity

    @ContributesAndroidInjector
    fun contributesRegistrationFragmentInjector(): RegistrationFragment

    @ContributesAndroidInjector
    fun contributesLoginFragmentInjector(): LoginFragment

    @ContributesAndroidInjector
    fun contributesLoansListFragmentInjector(): LoansListFragment

    @ContributesAndroidInjector
    fun contributeLoanDetailsFragmentInjector(): LoanDetailsFragment

    @ContributesAndroidInjector
    fun contributesSettingsFragmentInjector(): SettingsFragment

    @ContributesAndroidInjector
    fun contributeTutorialFragmentInjector(): TutorialFragment

    @ContributesAndroidInjector
    fun contributeNewLoanFragmentInjector(): NewLoanFragment

    @ContributesAndroidInjector
    fun contributeLoanCreatedFragmentInjector(): LoanCreatedFragment
}