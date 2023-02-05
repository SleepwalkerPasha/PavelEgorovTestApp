package ru.tinkoff.edu.popularfilms.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoInternetViewModel : ViewModel() {
    private val mutableCallback = MutableLiveData<Boolean>()
    val selectedCallback: LiveData<Boolean> get() = MutableLiveData()

    fun selectCallback(boolean: Boolean) {
        mutableCallback.value = boolean
    }
}