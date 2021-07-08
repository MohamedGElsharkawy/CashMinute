package com.sharkawy.cashminute.presentation.feature.credit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sharkawy.cashminute.domain.repositories.credit.CreditRepository

class CreditViewModelFactory(private val repository: CreditRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreditViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreditViewModel(
                repository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}