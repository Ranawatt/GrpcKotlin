package com.example.grpckotlin.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grpckotlin.data.GreeterRepository
import kotlinx.coroutines.launch

class GreeterViewModel(private val greeterRepository: GreeterRepository) : ViewModel() {

    val greeting: LiveData<String>
        get() = greeterRepository.greeting

    fun sayHello(message: String) {
        viewModelScope.launch {
            greeterRepository.sayHello(message)
        }
    }
}