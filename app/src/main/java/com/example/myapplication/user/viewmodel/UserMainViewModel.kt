package com.example.myapplication.user.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.data.PlateData

class UserMainViewModel : ViewModel() {
    val platesTokDetails = MutableLiveData<PlateData>()

    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                ApiImpl().login(json)
            }.onSuccess {
                if(it.success){
                    loginDetails.postValue(it.data)
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}