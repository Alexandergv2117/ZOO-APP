package com.example.zoo.data.network

import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.data.model.SpecieTypeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ZooApiClient {
    @GET("especie")
    suspend fun getAllSpecie(): Response<List<SpecieTypeModel>>

    @GET("especie")
    suspend fun getAnimalBySpecie(@Query("tipo") SpecieType: String): Response<List<AnimalTypeModel>>
}