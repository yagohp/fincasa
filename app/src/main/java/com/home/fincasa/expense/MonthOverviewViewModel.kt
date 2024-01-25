package com.home.fincasa.expense

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.home.fincasa.basics.ScreenStatus
import com.home.fincasa.models.Expense
import com.home.fincasa.models.MonthOverview

class MonthOverviewViewModel(private val repository: MonthOverviewRepository) : ViewModel() {
    private val _status = MutableLiveData<ScreenStatus>()
    val status: LiveData<ScreenStatus> = _status

    private val _monthOverview = MutableLiveData<MonthOverview>()
    val monthOverview: LiveData<MonthOverview> = _monthOverview

    private val _fixedExpenses = MutableLiveData<List<Expense>>()
    val listFixedExpenses: LiveData<List<Expense>> = _fixedExpenses

    private val _extraExpenses = MutableLiveData<List<Expense>>()
    val listExtraExpenses: LiveData<List<Expense>> = _extraExpenses

    //TODO: refatorar
    //var credentials: Credentials? = null

    //var playerState = MutableLiveData<PlayerState>()

    init {
//        if(repoCredentials.isLoggedIn){
//            credentials = repoCredentials.credentials
//            this.getMedias()
//        }
    }

    fun getMonthOverView(page: Int = 1) {
        _status.value = ScreenStatus.LOADING
        _monthOverview.value = repository.getOverView();
    }

    fun getFixedExpenses(page: Int = 1) {
        //TODO: implement retry
        repository.page = page
        //viewModelScope.launch {
        _status.value = ScreenStatus.LOADING
        _fixedExpenses.value = repository.getFixedExpenses();

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

    fun getExtraExpenses(page: Int = 1) {
        //TODO: implement retry
        repository.page = page
        //viewModelScope.launch {
        _status.value = ScreenStatus.LOADING
        _extraExpenses.value = repository.getExtraExpenses();

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