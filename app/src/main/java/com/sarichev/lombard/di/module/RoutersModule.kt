package com.sarichev.lombard.di.module

import com.sarichev.lombard.feature.loans.loancreated.LoanCreatedScreenRouter
import com.sarichev.lombard.feature.loans.loandetails.LoanDetailsScreenRouter
import com.sarichev.lombard.feature.loans.loanslist.LoansListScreenRouter
import com.sarichev.lombard.feature.loans.login.LoginScreenRouter
import com.sarichev.lombard.feature.loans.newloan.NewLoanScreenRouter
import com.sarichev.lombard.feature.loans.registration.RegistrationScreenRouter
import com.sarichev.lombard.feature.loans.settings.SettingsScreenRouter
import com.sarichev.lombard.feature.loans.tutorial.TutorialScreenRouter
import com.sarichev.lombard.navigation.impl.LoanCreatedScreenRouterImpl
import com.sarichev.lombard.navigation.impl.LoanDetailsScreenRouterImpl
import com.sarichev.lombard.navigation.impl.LoansListScreenRouterImpl
import com.sarichev.lombard.navigation.impl.LoginScreenRouterImpl
import com.sarichev.lombard.navigation.impl.NewLoanScreenRouterImpl
import com.sarichev.lombard.navigation.impl.RegistrationScreenRouterImpl
import com.sarichev.lombard.navigation.impl.SettingsScreenRouterImpl
import com.sarichev.lombard.navigation.impl.TutorialScreenRouterImpl
import dagger.Binds
import dagger.Module

@Module
interface RoutersModule {

    @Binds
    fun bindRegistrationScreenRouter(impl: RegistrationScreenRouterImpl): RegistrationScreenRouter

    @Binds
    fun bindLoginScreenRouter(impl: LoginScreenRouterImpl): LoginScreenRouter

    @Binds
    fun bindLoansListScreenRouter(impl: LoansListScreenRouterImpl): LoansListScreenRouter

    @Binds
    fun bindLoanDetailsScreenRouter(impl: LoanDetailsScreenRouterImpl): LoanDetailsScreenRouter

    @Binds
    fun bindSettingsScreenRouter(impl: SettingsScreenRouterImpl): SettingsScreenRouter

    @Binds
    fun bindTutorialScreenRouter(impl: TutorialScreenRouterImpl): TutorialScreenRouter

    @Binds
    fun bindNewLoanScreenRouter(impl: NewLoanScreenRouterImpl): NewLoanScreenRouter

    @Binds
    fun bindLoanCreatedScreenRouter(impl: LoanCreatedScreenRouterImpl): LoanCreatedScreenRouter
}