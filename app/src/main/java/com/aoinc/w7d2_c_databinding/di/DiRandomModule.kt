package com.aoinc.w7d2_c_databinding.di

import com.aoinc.w7d2_c_databinding.model.network.RandomUserRetrofit
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DiRandomModule {

    @Provides
    @Singleton
    fun retrofitInstance(): RandomUserRetrofit =
        RandomUserRetrofit()
}