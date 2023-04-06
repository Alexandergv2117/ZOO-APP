package com.example.zoo.domain.animal

import com.example.zoo.data.DB.Animal.toDB
import com.example.zoo.data.ZooRepository
import javax.inject.Inject

class GetAnimalTypeUseCase @Inject constructor(
    private val repository: ZooRepository
){
    suspend operator fun invoke(): List<AnimalType> {
        val animalType = repository.getAnimalFromDB()
        return if (animalType.isNotEmpty()) {
            animalType
        } else {
            val apiAnimalType = repository.getAnimalFromApi()
            if (apiAnimalType.isNotEmpty()) {
                repository.clearTableSpecie()
                repository.insertAnimals(apiAnimalType.map {
                    it.toDB()
                })
                apiAnimalType
            } else {
                emptyList()
            }
        }
    }
}