package com.example.zoo.domain.animal

import com.example.zoo.data.DB.Animal.AnimalTypeEntity
import com.example.zoo.data.model.AnimalTypeModel

data class AnimalType (
    val id: Int,
    val imagen: String,
    val nombre: String,
    val scientific_name: String,
    val origen: String,
    val habitat: String,
    val riesgo: String,
    val tamanio: String,
    val reproduccion: String,
    val alimentacion: String,
    val descripcion: String,
    val video: String,
    val mapa: String,
    val audio: String,
    val gif: String,
    val especie: String
        ) {
}

fun AnimalTypeModel.toDomain() = AnimalType(
    id,
    imagen,
    nombre,
    scientific_name,
    origen,
    habitat,
    riesgo,
    tamanio,
    reproduccion,
    alimentacion,
    descripcion,
    video,
    mapa,
    audio,
    gif,
    especie
        )

fun AnimalTypeEntity.toDomain() = AnimalType(
    id,
    imagen,
    nombre,
    scientific_name,
    origen,
    habitat,
    riesgo,
    tamanio,
    reproduccion,
    alimentacion,
    descripcion,
    video,
    mapa,
    audio,
    gif,
    especie
        )