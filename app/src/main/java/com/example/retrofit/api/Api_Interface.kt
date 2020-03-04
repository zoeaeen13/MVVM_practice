package com.example.retrofit.api

import com.example.retrofit.TestData
import retrofit2.Call
import retrofit2.http.GET

interface Api_Interface {
    @GET("albums/1")
    fun getAlbums(): Call<TestData>

}