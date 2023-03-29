package com.example.zoo.data.DB.Specie

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.zoo.data.DB.Specie.SpecieTypeEntity

@Dao
interface SpecieTypeDao {
    @Query("SELECT * FROM specie")
    suspend fun getAllSpecie(): List<SpecieTypeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSpecie(species: List<SpecieTypeEntity>)

    @Query("DELETE FROM specie")
    suspend fun deleteAllSpecie()
}