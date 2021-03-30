package com.aoinc.w7d2_c_databinding.di

import com.aoinc.w7d2_c_databinding.viewmodel.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DiRandomModule::class])
interface DiRandomComponent {
    fun inject(mainViewModel: MainViewModel)
}