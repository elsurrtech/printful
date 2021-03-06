package com.deepesh.printful.data.retrofit
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient  {
    const val Base_URl = "https://reqres.in/"
    val retrofitClient: Retrofit.Builder by lazy {

        val gson = Gson()
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Base_URl)

    }
    val apiInterface: ApiInterface by lazy {
        retrofitClient
            .build()
            .create(ApiInterface::class.java)
    }



}