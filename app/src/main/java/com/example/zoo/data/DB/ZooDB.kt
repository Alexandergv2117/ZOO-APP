package com.example.zoo.data.DB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.zoo.data.DB.Animal.AnimalTypeDao
import com.example.zoo.data.DB.Animal.AnimalTypeEntity
import com.example.zoo.data.DB.Specie.SpecieTypeDao
import com.example.zoo.data.DB.Specie.SpecieTypeEntity

@Database(
    entities = [
        SpecieTypeEntity::class,
        AnimalTypeEntity::class
    ],
    version = 1
)
abstract class ZooDB: RoomDatabase() {
    abstract fun getSpecieTypeDao(): SpecieTypeDao

    abstract fun getAnimalTypeDao(): AnimalTypeDao
}