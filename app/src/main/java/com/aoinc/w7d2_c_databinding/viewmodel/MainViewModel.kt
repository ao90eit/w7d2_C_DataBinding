package com.aoinc.w7d2_c_databinding.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.aoinc.w7d2_c_databinding.BR
import com.aoinc.w7d2_c_databinding.model.data.RandomUsers
import com.aoinc.w7d2_c_databinding.model.network.RandomUserRetrofit
import com.aoinc.w7d2_c_databinding.util.RandomAppSingleton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel : BaseObservable() {

    @Inject
    lateinit var retrofit: RandomUserRetrofit

    init {
        RandomAppSingleton.diRandomComponent.inject(this)
        retrofit.getRandomResults().enqueue(object : Callback<RandomUsers>{

            override fun onResponse(call: Call<RandomUsers>, response: Response<RandomUsers>) {
                response.body()?.results?.let {
                    val sBuilder = StringBuilder()
                    it.forEach { user ->
                        sBuilder.append("${user?.name?.title} ${user?.name?.last}\n")
                    }

                    bookName = sBuilder.toString()
                } ?: {
                    Log.d("TAG_X", "results are empty")
                    bookName = "The results are empty"
                }()
            }

            override fun onFailure(call: Call<RandomUsers>, t: Throwable) {
                Log.d("TAG_X", "failure -> ${t.localizedMessage}")
            }
        })
    }

    @get: Bindable
    var bookName: String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.bookName)
    }


}