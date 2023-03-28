package com.example.zoo.UI.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommentViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is comment Fragment"
    }
    val text: LiveData<String> = _text
}