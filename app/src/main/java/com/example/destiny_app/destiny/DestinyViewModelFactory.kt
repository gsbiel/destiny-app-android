package com.example.destiny_app.destiny

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class DestinyViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DestinyViewModel::class.java)){
            return DestinyViewModel() as T
        }
        throw IllegalArgumentException("Unknown view model class!")
    }
}