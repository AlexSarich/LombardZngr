package com.sarichev.lombard.shared.loans.core.domain.entity

data class LoanConditions(
    val maxAmount: Long,
    val percent: Double,
    val period: Int
)
