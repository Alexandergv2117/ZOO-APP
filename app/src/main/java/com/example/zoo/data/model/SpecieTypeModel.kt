package com.example.zoo.data.model

import com.google.gson.annotations.SerializedName

data class SpecieTypeModel(
    @SerializedName("id")val id: Int,
    @SerializedName("tipo") val tipo: String,
    @SerializedName("link_foto") val link_foto: String
)