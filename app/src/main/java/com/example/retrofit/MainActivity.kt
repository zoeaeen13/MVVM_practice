package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.retrofit.api.ApiService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var testViewModel: TestViewModel
    lateinit var testObserver: Observer<TestData>  //Observer和LiveData型態一致

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testViewModel = ViewModelProviders.of(this).get(TestViewModel::class.java)
        testViewModel.RequestTestData()
        testObserver = Observer{
            println("==========$it")
            testTextView.text = it.title
        }
        testViewModel.getTestData().observe(this, testObserver)

    }

}
