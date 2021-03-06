package com.deepesh.printful.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.deepesh.printful.data.model.ApiResponse
import com.deepesh.printful.repository.MainActivityRepository
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var mainActivityRepository: MainActivityRepository = MainActivityRepository()

    fun getNews() : LiveData<Response<ApiResponse>>
    {
        return  mainActivityRepository.getNews()
    }
    fun callApi(){
        mainActivityRepository.callApi()
    }
}