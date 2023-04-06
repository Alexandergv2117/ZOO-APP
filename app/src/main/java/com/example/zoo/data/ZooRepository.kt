package com.example.zoo.data

import com.example.zoo.data.DB.Animal.AnimalTypeDao
import com.example.zoo.data.DB.Animal.AnimalTypeEntity
import com.example.zoo.data.DB.Specie.SpecieTypeDao
import com.example.zoo.data.DB.Specie.SpecieTypeEntity
import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.data.network.ZooService
import com.example.zoo.domain.animal.AnimalType
import com.example.zoo.domain.animal.toDomain
import com.example.zoo.domain.specie.SpecieType
import com.example.zoo.domain.specie.toDomain
import javax.inject.Inject

class ZooRepository @Inject constructor(
    private val zooApi: ZooService,
    private val specieTypeDao: SpecieTypeDao,
    private val animalTypeDao: AnimalTypeDao
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

    // Animales

    suspend fun getAnimalFromApi(tipo: String): List<AnimalType> {
        val response: List<AnimalTypeModel> = zooApi.getAnimalBySpecie(tipo)
        return response.map {
            it.toDomain()
        }
    }

    suspend fun getAnimalFromDB(): List<AnimalType> {
        val response = animalTypeDao.getAnimalBySpecie()
        return response.map {
            it.toDomain()
        }
    }

    suspend fun insertAnimals(animals: List<AnimalTypeEntity>) {
        animalTypeDao.insertAllAnimal(animals)
    }
}