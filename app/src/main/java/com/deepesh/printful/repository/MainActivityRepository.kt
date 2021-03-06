package com.deepesh.printful.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.deepesh.printful.data.model.ApiResponse
import com.deepesh.printful.data.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityRepository {
    val TAG: String = MainActivityRepository::class.java.simpleName
    private val mutalbleResponse: MutableLiveData<Response<ApiResponse>> =
        MutableLiveData<Response<ApiResponse>>()
    fun getNews() : LiveData<Response<ApiResponse>> {
       return  mutalbleResponse
    }
    fun callApi() {

        val call = RetrofitClient.apiInterface.getNews()
        call.enqueue(object : Callback<ApiResponse> {
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.e(TAG, "OOPs ! Something went wrong$call")
            }
            override fun onResponse(
                call: Call<ApiResponse>,
                response: Response<ApiResponse>
            ) {

                mutalbleResponse.value=response
            }
        })

    }
}