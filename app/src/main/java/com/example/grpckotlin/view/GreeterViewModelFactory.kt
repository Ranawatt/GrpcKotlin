package com.example.grpckotlin.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.grpckotlin.data.GreeterRepository

class GreeterViewModelFactory(private val greeterRepository: GreeterRepository): ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GreeterViewModel(greeterRepository) as T
    }
}