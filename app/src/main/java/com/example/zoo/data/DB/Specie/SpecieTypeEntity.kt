package com.example.zoo.data.DB.Specie

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.zoo.domain.specie.SpecieType

@Entity(tableName = "specie")
data class SpecieTypeEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "tipo") val tipo: String,
    @ColumnInfo(name = "link_foto") val link_foto: String
    )

fun SpecieType.toDB() = SpecieTypeEntity(
    id = id,
    tipo = tipo,
    link_foto = link_foto
)
