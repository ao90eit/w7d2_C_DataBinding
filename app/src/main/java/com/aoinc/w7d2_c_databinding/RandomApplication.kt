package com.aoinc.w7d2_c_databinding

import android.app.Application
import com.aoinc.w7d2_c_databinding.di.DaggerDiRandomComponent
import com.aoinc.w7d2_c_databinding.di.DiRandomComponent
import com.aoinc.w7d2_c_databinding.util.RandomAppSingleton

class RandomApplication : Application() {

    private lateinit var diRandomComponent: DiRandomComponent

    override fun onCreate() {
        super.onCreate()

        diRandomComponent = DaggerDiRandomComponent.create()
        RandomAppSingleton.diRandomComponent = diRandomComponent
    }
}