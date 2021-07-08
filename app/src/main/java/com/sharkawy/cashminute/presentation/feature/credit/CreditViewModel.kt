package com.sharkawy.cashminute.presentation.feature.credit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sharkawy.cashminute.domain.repositories.credit.CreditRepository
import com.sharkawy.cashminute.domain.repositories.credit.creditRepository
import com.sharkawy.cashminute.entities.CreditResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreditViewModel(private val repository: CreditRepository = creditRepository) : ViewModel() {

    // message
    private val _message: MutableLiveData<String> = MutableLiveData()
    val message: LiveData<String> get() = _message

    fun sendCreditPayload(body: MutableMap<String, String>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.sendCreditPayload(body).apply {
                val result: CreditResponse = this as CreditResponse

                _message.postValue(result.msg)
            }
        }
    }
}