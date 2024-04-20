package com.example.retrofitapi

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FoxViewModel : ViewModel() {
    private val repository = FoxRepository()
    private val _foxResponse = MutableLiveData<Fox?>()
    val foxResponse: LiveData<Fox?> get() = _foxResponse

    init {
        viewModelScope.launch {
            try {
                val response = repository.getRandomFox()
                _foxResponse.value = response
            } catch (e: Exception) {
                Log.e("21--",e.message!!)
                _foxResponse.value = null
            }
        }
    }
}
