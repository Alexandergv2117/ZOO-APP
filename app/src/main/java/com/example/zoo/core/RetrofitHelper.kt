package com.example.zoo.core

import com.example.zoo.utils.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Const.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}