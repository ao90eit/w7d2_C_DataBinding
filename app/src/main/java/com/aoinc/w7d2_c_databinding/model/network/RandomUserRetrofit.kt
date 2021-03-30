package com.aoinc.w7d2_c_databinding.model.network

import com.aoinc.w7d2_c_databinding.model.data.RandomUsers
import com.aoinc.w7d2_c_databinding.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class RandomUserRetrofit {

    private var randomUserService: RandomUserService

    init {
        randomUserService = createRetrofitAPI(createRetrofit())
    }

    private fun createRetrofitAPI(retrofit: Retrofit): RandomUserService =
        retrofit.create(RandomUserService::class.java)

    private fun createRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun getRandomResults(): Call<RandomUsers> =
        randomUserService.getRandomUsers(Constants.SIZE)
}

interface RandomUserService {
    @GET(Constants.PATH)
    fun getRandomUsers(@Query(Constants.QUERY) sizeOfResults: Int): Call<RandomUsers>
}