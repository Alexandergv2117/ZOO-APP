package com.example.zoo.data.network

import com.example.zoo.core.RetrofitHelper
import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.data.model.SpecieTypeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ZooService @Inject constructor(
    private val api: ZooApiClient
) {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllSpecies(): List<SpecieTypeModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllSpecie()
            response.body() ?: emptyList()
        }
    }

    suspend fun getAnimalBySpecie(): List<AnimalTypeModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAnimalBySpecie()
            response.body() ?: emptyList()
        }
    }
}