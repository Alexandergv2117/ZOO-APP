package com.example.zoo.domain.animal

import com.example.zoo.data.DB.Animal.toDB
import com.example.zoo.data.ZooRepository
import javax.inject.Inject

class GetAnimalTypeUseCase @Inject constructor(
    private val repository: ZooRepository
){
    suspend operator fun invoke(tipo: String): List<AnimalType> {
        val apiAnimalType = repository.getAnimalFromApi(tipo)
        return if (apiAnimalType.isNotEmpty()) {
            repository.insertAnimals(apiAnimalType.map {
                it.toDB()
            })
            apiAnimalType
        } else {
            val animalType = repository.getAnimalFromDB()
            if (animalType.isNotEmpty()) {
                animalType
            } else {
                emptyList()
            }
        }
    }
}