package com.example.zoo.domain.specie

import com.example.zoo.data.DB.Specie.toDB
import com.example.zoo.data.ZooRepository
import javax.inject.Inject

class GetSpecieTypeUseCase @Inject constructor(
    private val repository: ZooRepository
) {
    suspend operator fun invoke(): List<SpecieType> {
        val specieType = repository.getSpecieFromDB()
        return if (specieType.isNotEmpty()) {
            specieType
        } else {
            val apiSpecieType = repository.getSpecieFromApi()
            if (apiSpecieType.isNotEmpty()) {
                repository.clearTableSpecie()
                repository.insertSpecies(apiSpecieType.map {
                    it.toDB()
                })
                apiSpecieType
            } else {
                emptyList()
            }
        }
    }
}