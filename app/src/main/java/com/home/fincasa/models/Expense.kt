package com.home.fincasa.models

import java.util.Date

data class Expense (
    val uuid: String,
    val title: String,
    val dueDate: Date,
    val paid: Boolean,
    val paymentDate: Date? = null,
    val category: String,
    val amountPaid: Float,
    val value: Float,
    val paidWithAccount: String? = null,
    val color: Int,
    val type: Int
)