package com.example.zoo.domain.animal

import android.widget.Toast
import com.example.zoo.data.DB.Animal.toDB
import com.example.zoo.data.ZooRepository
import javax.inject.Inject

class SRLAnimalTypeUseCase @Inject constructor(
    private val repository: ZooRepository
){
    suspend operator fun invoke(tipo: String): List<AnimalType> {
        return try {
            val apiAnimalType = repository.getAnimalFromApi(tipo)
            if (apiAnimalType.isNotEmpty()) {
                repository.clearTableSpecie()
                repository.insertAnimals(apiAnimalType.map {
                    it.toDB()
                })
                apiAnimalType
            }  else {
                emptyList()
            }
        } catch (e: Exception) {
            val animalTypeDB = repository.getAnimalFromDB(tipo)

            if (animalTypeDB.isNotEmpty()) {
                animalTypeDB
            } else {
                listOf(
                    AnimalType(
                        id = 0,
                        imagen = "https://www.elegantthemes.com/blog/wp-content/uploads/2020/06/000-501-http-error.png",
                        nombre = "Error : 501",
                        scientific_name = "Error : 501",
                        origen = "Error : 501",
                        habitat = "Error : 501",
                        riesgo = "Error : 501",
                        tamanio = "Error : 501",
                        reproduccion = "Error : 501",
                        alimentacion = "Error : 501",
                        descripcion = "Error : 501",
                        video = "Error : 501",
                        mapa = "Error : 501",
                        audio = "Error : 501",
                        gif = "Error : 501",
                        especie = "Error : 501"
                    )
                )
            }
        }
    }
}