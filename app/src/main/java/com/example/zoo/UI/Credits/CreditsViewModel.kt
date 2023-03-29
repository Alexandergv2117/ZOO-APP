package com.example.zoo.UI.credits

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreditsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is credits Fragment"
    }
    val text: LiveData<String> = _text
}