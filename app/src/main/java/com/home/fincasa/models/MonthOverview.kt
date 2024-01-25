package com.home.fincasa.models

import java.util.Date

data class MonthOverview (
    val balance: Float,
    val date: Date,
    val income: Float,
    val outgoing: Float,
    val creditCardOutgoing: Float
)