package com.example.zoo.data.DB.Animal

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimalTypeDao {
    @Query("SELECT * FROM animal")
    suspend fun getAnimalBySpecie(): List<AnimalTypeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAnimal(animals: List<AnimalTypeEntity>)
}