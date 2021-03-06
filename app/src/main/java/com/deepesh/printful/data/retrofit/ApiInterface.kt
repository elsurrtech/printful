package com.deepesh.printful.data.retrofit

import com.deepesh.printful.data.model.ApiResponse
import retrofit2.Call

import retrofit2.http.GET

interface ApiInterface {

    @GET("api/users?page=2")
    fun getNews(): Call<ApiResponse>
}