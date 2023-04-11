package com.example.zoo.data

import com.example.zoo.data.DB.Specie.SpecieTypeDao
import com.example.zoo.data.DB.Specie.SpecieTypeEntity
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.data.network.ZooService
import com.example.zoo.domain.specie.SpecieType
import com.example.zoo.domain.specie.toDomain
import javax.inject.Inject

class ZooRepository @Inject constructor(
    private val zooApi: ZooService,
    private val specieTypeDao: SpecieTypeDao
){
    suspend fun getSpecieFromApi(): List<SpecieType> {
        val response: List<SpecieTypeModel> = zooApi.getAllSpecies()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getSpecieFromDB(): List<SpecieType> {
        val response = specieTypeDao.getAllSpecie()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertSpecies(species: List<SpecieTypeEntity>) {
        specieTypeDao.insertAllSpecie(species)
    }

    suspend fun clearTableSpecie() {
        specieTypeDao.deleteAllSpecie()
    }
}