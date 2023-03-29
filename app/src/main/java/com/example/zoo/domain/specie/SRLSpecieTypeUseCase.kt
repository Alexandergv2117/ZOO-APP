package com.example.zoo.domain.specie

import com.example.zoo.data.DB.Specie.toDB
import com.example.zoo.data.ZooRepository
import javax.inject.Inject

class SRLSpecieTypeUseCase @Inject constructor(
    private val repository: ZooRepository
){
    suspend operator fun invoke(): List<SpecieType> {
        return try {
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
        } catch (e: Exception) {
            listOf(
                SpecieType(
                    id = 0,
                    tipo = "Error : 501",
                    link_foto = "https://www.elegantthemes.com/blog/wp-content/uploads/2020/06/000-501-http-error.png"
                )
            )
        }
    }
}