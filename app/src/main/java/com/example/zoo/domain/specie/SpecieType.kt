package com.example.zoo.domain.specie

import com.example.zoo.data.DB.Specie.SpecieTypeEntity
import com.example.zoo.data.model.SpecieTypeModel

data class SpecieType (
    val id: Int,
    val tipo: String,
    val link_foto: String
)

fun SpecieTypeModel.toDomain() = SpecieType(
    id,
    tipo,
    link_foto
)

fun SpecieTypeEntity.toDomain() = SpecieType(
    id,
    tipo,
    link_foto
)