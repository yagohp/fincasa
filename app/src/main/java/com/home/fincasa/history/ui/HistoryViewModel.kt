package com.home.fincasa.history.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.fincasa.basics.ScreenStatus
import com.home.fincasa.history.data.HistoryRepository
import com.home.fincasa.models.Transaction

class HistoryViewModel(private val repository: HistoryRepository) : ViewModel() {
    private val _status = MutableLiveData<ScreenStatus>()
    val status: LiveData<ScreenStatus> = _status

    private val _transactions = MutableLiveData<List<Transaction>>()
    val listTransactions: LiveData<List<Transaction>> = _transactions

    //TODO: refatorar
    //var credentials: Credentials? = null

    //var playerState = MutableLiveData<PlayerState>()

    init {
//        if(repoCredentials.isLoggedIn){
//            credentials = repoCredentials.credentials
//            this.getMedias()
//        }
    }

    fun getHistory(page: Int = 1) {
        //TODO: implement retry
        repository.page = page
        //viewModelScope.launch {
        _status.value = ScreenStatus.LOADING
        _transactions.value = repository.getTransactions();

//            repository.getMedias(object : DataResult {
//                override fun onSuccess(response: Result.Success<*>?) {
//                    try {
//                        _medias.value = response?.data as List<Media>
//                        _status.value = ScreenStatus.DONE
//                    } catch (e: Exception) {
//                        _medias.value = listOf()
//                        _status.value = ScreenStatus.ERROR
//                    }
//                }
//
//                override fun onFailure(response: Result.Error) {
//                    Log.d("MediasViewModel", "Error: ${response.exception.message.toString()}")
//                    _medias.value = listOf()
//                    _status.value = ScreenStatus.ERROR
//                }
//            })
        //}
    }
}