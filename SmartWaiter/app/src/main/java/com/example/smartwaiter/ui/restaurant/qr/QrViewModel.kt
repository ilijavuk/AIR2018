package com.example.smartwaiter.ui.restaurant.qr

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartwaiter.repository.StolRepostiory
import hr.foi.air.webservice.model.Stol
import hr.foi.air.webservice.util.Resource
import kotlinx.coroutines.launch

class QrViewModel(private val repository: StolRepostiory) : ViewModel() {
    val myResponse: MutableLiveData<Resource<List<Stol>>> = MutableLiveData()

    fun getTableByHash(
        table: String,
        method: String,
        hash: String
    ) {
        viewModelScope.launch {
            val response=repository.getTableByHash(table,method,hash)
            myResponse.value=response
        }
    }
    suspend fun saveActiveRestaurant(activeRestaurant: String) {
        repository.saveActiveRestaurant(activeRestaurant)
    }

}