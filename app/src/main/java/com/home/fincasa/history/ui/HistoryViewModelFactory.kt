package com.home.fincasa.history.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.home.fincasa.history.data.HistoryDataSource
import com.home.fincasa.history.data.HistoryRepository

class HistoryViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HistoryViewModel::class.java)) {
            return HistoryViewModel(
                repository = HistoryRepository(
                    dataSource = HistoryDataSource()
                )
            ) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}