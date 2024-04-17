package com.sarichev.lombard.feature.loans.newloan.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sarichev.lombard.component.loans.commonclasses.presentation.state.ErrorEvent
import com.sarichev.lombard.component.loans.commonclasses.presentation.state.ScreenState
import com.sarichev.lombard.component.loans.commonclasses.presentation.state.SingleLiveEvent
import com.sarichev.lombard.feature.loans.newloan.NewLoanScreenRouter
import com.sarichev.lombard.shared.loans.core.domain.entity.LoanConditions
import com.sarichev.lombard.shared.loans.core.domain.entity.LoanRequest
import com.sarichev.lombard.shared.loans.core.domain.entity.result.RequestError
import com.sarichev.lombard.shared.loans.core.domain.entity.result.RequestResult
import com.sarichev.lombard.shared.loans.core.domain.usecase.CreateNewLoanUseCase
import com.sarichev.lombard.shared.loans.core.domain.usecase.GetLoanConditionsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewLoanViewModel @Inject constructor(
    private val getLoanConditionsUseCase: GetLoanConditionsUseCase,
    private val createNewLoanUseCase: CreateNewLoanUseCase,
    private val router: NewLoanScreenRouter
) : ViewModel() {

    private val _state: MutableLiveData<ScreenState<LoanConditions>> =
        MutableLiveData(ScreenState.Initial)
    val state: LiveData<ScreenState<LoanConditions>> = _state

    private val _errorEvent = SingleLiveEvent<ErrorEvent>()
    val errorEvent: LiveData<ErrorEvent> = _errorEvent

    private var _loanConditions: LoanConditions? = null
    private val loanConditions
        get() = _loanConditions ?: throw RuntimeException("Loan conditions are null!")

    fun loadLoanConditions() {
        _loanConditions?.let {
            _state.value = ScreenState.Loading
            _state.value = ScreenState.Content(it)
            return
        }
        viewModelScope.launch {
            _state.value = ScreenState.Loading
            when (val result = getLoanConditionsUseCase()) {
                is RequestResult.Success -> {
                    _loanConditions = result.content
                    _state.value = ScreenState.Content(result.content)
                }

                is RequestResult.Error -> {
                    _state.value = ScreenState.Error
                    when (val error = result.requestError) {
                        is RequestError.ServerError -> {
                            _errorEvent.value = ErrorEvent.ServerError
                        }

                        is RequestError.NetworkError -> {
                            _errorEvent.value = ErrorEvent.NetworkError
                        }

                        else -> throw RuntimeException("Unexpected error during conditions loading: $error")
                    }
                }
            }
        }
    }

    fun sendLoanCreateRequest(
        amount: String, firstName: String, lastName: String, phone: String
    ) {
        viewModelScope.launch {
            if (amount.isBlank() || firstName.isBlank() || lastName.isBlank() || phone.isBlank()) {
                _errorEvent.value = ErrorEvent.EmptyFields
                _state.value = ScreenState.Content(loanConditions)
                return@launch
            }
            _state.value = ScreenState.Loading
            val loanRequest =
                LoanRequest(
                    amount.toLong(),
                    firstName,
                    lastName,
                    loanConditions.percent,
                    loanConditions.period,
                    phone
                )

            when (val result = createNewLoanUseCase(loanRequest)) {
                is RequestResult.Success -> {
                    router.openLoanCreatedScreen(result.content)
                }

                is RequestResult.Error -> {
                    _state.value = ScreenState.Content(loanConditions)
                    when (val error = result.requestError) {
                        is RequestError.NetworkError -> {
                            _errorEvent.value = ErrorEvent.NetworkError
                        }

                        is RequestError.ServerError -> {
                            _errorEvent.value = ErrorEvent.ServerError
                        }

                        is RequestError.InvalidInput -> {
                            _errorEvent.value = ErrorEvent.MaxAmountExceeded
                        }

                        else -> throw RuntimeException("Unexpected error in loan create flow: $error")
                    }
                }
            }
        }
    }
}