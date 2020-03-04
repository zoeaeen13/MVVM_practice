package com.example.retrofit.api

import com.example.retrofit.TestData
import com.example.retrofit.TestViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiFunction{
    companion object {
        fun requestTestData(viewModel: TestViewModel){
            val call = ApiService.mApiClent.getAlbums()
            call.enqueue(object: Callback<TestData>{
                override fun onFailure(call: Call<TestData>?, t: Throwable?) {

                }
                override fun onResponse(call: Call<TestData>?, response: Response<TestData>?) {
                    if (response!!.code() == 200){
                        val responseBody = response.body()
                        viewModel.setTestData(responseBody!!)   //塞值
                    }
                }
            })
        }
    }
}