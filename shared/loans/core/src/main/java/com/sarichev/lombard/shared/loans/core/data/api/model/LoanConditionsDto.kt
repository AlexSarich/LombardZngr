package com.sarichev.lombard.shared.loans.core.data.api.model

data class LoanConditionsDto(
    val maxAmount: Long,
    val percent: Double,
    val period: Int
)
