package com.sarichev.lombard.di.module

import androidx.lifecycle.ViewModel
import com.sarichev.lombard.di.annotations.ViewModelKey
import com.sarichev.lombard.feature.loans.loancreated.presentation.LoanCreatedViewModel
import com.sarichev.lombard.feature.loans.loandetails.presentation.LoanDetailsViewModel
import com.sarichev.lombard.feature.loans.loanslist.presentation.LoansListViewModel
import com.sarichev.lombard.feature.loans.login.presentation.LoginViewModel
import com.sarichev.lombard.feature.loans.newloan.presentation.NewLoanViewModel
import com.sarichev.lombard.feature.loans.registration.presentation.RegistrationViewModel
import com.sarichev.lombard.feature.loans.settings.presentation.SettingsViewModel
import com.sarichev.lombard.feature.loans.tutorial.presentation.TutorialViewModel
import com.sarichev.lombard.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RegistrationViewModel::class)
    fun bindRegistrationViewModel(viewModel: RegistrationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TutorialViewModel::class)
    fun bindTutorialViewModel(viewModel: TutorialViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoansListViewModel::class)
    fun bindLoansListViewModel(viewModel: LoansListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoanDetailsViewModel::class)
    fun bindLoanDetailsViewModel(viewModel: LoanDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NewLoanViewModel::class)
    fun bindNewLoanViewModel(viewModel: NewLoanViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoanCreatedViewModel::class)
    fun bindLoanCreatedViewModel(viewModel: LoanCreatedViewModel): ViewModel
}