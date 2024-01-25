package com.home.fincasa.expense

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MonthOverviewViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonthOverviewViewModel::class.java)) {
            return MonthOverviewViewModel(
                repository = MonthOverviewRepository(
                    dataSource = MonthOverviewDataSource()
                )
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}