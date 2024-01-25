package com.home.fincasa.models

import java.util.Date

data class Transaction(
    val id: Int,
    val uuid: String,
    val date: Date,
    val title: String,
    val category: String,
    val value: Float,
    val account: String,
    val color: Int,
    val type: Int
)