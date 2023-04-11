package com.example.zoo.data.network

import com.example.zoo.data.model.SpecieTypeModel
import retrofit2.Response
import retrofit2.http.GET

interface ZooApiClient {
    @GET("especie")
    suspend fun getAllSpecie(): Response<List<SpecieTypeModel>>
}