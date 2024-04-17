package com.sarichev.lombard.component.loans.commonclasses.presentation.state

sealed class ErrorEvent {

    object ServerError : ErrorEvent()

    object NetworkError : ErrorEvent()

    object UserNotFound : ErrorEvent()

    object UserAlreadyExists : ErrorEvent()

    object MaxAmountExceeded : ErrorEvent()

    object EmptyFields : ErrorEvent()
}
