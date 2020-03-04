package com.example.retrofit.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    val mClient= OkHttpClient.Builder().build()

    val mApiClent: Api_Interface by lazy {
        val mRetrofit= Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .client(mClient)
            .build()

        mRetrofit.create(Api_Interface::class.java)
    }
}