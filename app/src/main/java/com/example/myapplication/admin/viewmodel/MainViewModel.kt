package com.example.myapplication.admin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.admin.model.data.ListData
import com.example.myapplication.admin.model.remote.ApiImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val accountList = MutableLiveData<List<ListData>>()

    fun getAccountList(token: String) {
        viewModelScope.launch(Dispatchers.Default) {
            kotlin.runCatching {
                ApiImpl().getAccountList(token)
            }.onSuccess {
                if(it.success){
                    accountList.postValue(it.data)
                }
            }.onFailure {
                it.printStackTrace()
            }
        }
    }
}