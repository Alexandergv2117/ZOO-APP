package com.example.zoo.data.DB.Animal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.domain.animal.AnimalType

@Entity(tableName = "animal")
data class AnimalTypeEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "imagen") val imagen: String,
    @ColumnInfo(name = "nombre") val nombre: String,
    @ColumnInfo(name = "scientific_name") val scientific_name: String,
    @ColumnInfo(name = "origen") val origen: String,
    @ColumnInfo(name = "habitat") val habitat: String,
    @ColumnInfo(name = "riesgo") val riesgo: String,
    @ColumnInfo(name = "tamanio") val tamanio: String,
    @ColumnInfo(name = "reproduccion") val reproduccion: String,
    @ColumnInfo(name = "alimentacion") val alimentacion: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "video") val video: String,
    @ColumnInfo(name = "mapa") val mapa: String,
    @ColumnInfo(name = "audio") val audio: String,
    @ColumnInfo(name = "gif") val gif: String,
    @ColumnInfo(name = "especie") val especie: String
    )

fun AnimalType.toDB() = AnimalTypeEntity(
    id = id,
    imagen = imagen,
    nombre = nombre,
    scientific_name = scientific_name,
    origen = origen,
    habitat = habitat,
    riesgo = riesgo,
    tamanio = tamanio,
    reproduccion = reproduccion,
    alimentacion = alimentacion,
    descripcion = descripcion,
    video = video,
    mapa = mapa,
    audio = audio,
    gif = gif,
    especie = especie
    )