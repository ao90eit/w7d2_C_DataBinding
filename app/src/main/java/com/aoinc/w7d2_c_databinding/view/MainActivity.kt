package com.aoinc.w7d2_c_databinding.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.aoinc.w7d2_c_databinding.viewmodel.MainViewModel
import com.aoinc.w7d2_c_databinding.R
import com.aoinc.w7d2_c_databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val mainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.viewModel = mainViewModel

        // assume we're making an API call
//        Handler(mainLooper).postDelayed({
//            mainViewModel.bookName = "4-Hour Work Week"
//        }, 3000)
    }
}