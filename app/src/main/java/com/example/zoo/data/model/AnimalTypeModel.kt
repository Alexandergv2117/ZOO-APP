package com.example.zoo.data.model

import com.google.gson.annotations.SerializedName

data class AnimalTypeModel (
    @SerializedName("id") val id: Int,
    @SerializedName("imagen") val imagen: String,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("scientific_name") val scientific_name: String,
    @SerializedName("origen") val origen: String,
    @SerializedName("habitat") val habitat: String,
    @SerializedName("riesgo") val riesgo: String,
    @SerializedName("tamanio") val tamanio: String,
    @SerializedName("reproduccion") val reproduccion: String,
    @SerializedName("alimentacion") val alimentacion: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("video") val video: String,
    @SerializedName("mapa") val mapa: String,
    @SerializedName("audio") val audio: String,
    @SerializedName("gif") val gif: String,
    @SerializedName("especie") val especie: String
)