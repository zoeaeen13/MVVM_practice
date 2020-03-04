package com.example.retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofit.api.ApiFunction

class TestViewModel: ViewModel() {
    //資料
    private var testData = MutableLiveData<TestData>()

    //給外部呼叫api用
    fun RequestTestData(){  //一般參數會帶token，這裡不用
        ApiFunction.requestTestData(this)
    }

    //讓ApiFunction呼叫，用來賦值
    fun setTestData(result: TestData){
//        testData.postValue = result
        testData.value= result
    }

    //給Observer觀察，會回傳LiveData
    fun getTestData(): MutableLiveData<TestData> {
        return testData
    }


}