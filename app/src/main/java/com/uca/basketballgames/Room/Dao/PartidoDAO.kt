package com.uca.basketballgames.Room.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uca.basketballgames.Room.Entities.Partido

@Dao
interface PartidoDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insert(partido: Partido)

    @Query("SELECT * FROM `Match`")
    fun getAllPartidos():LiveData<List<Partido>>

    @Query("DELETE FROM `Match`")
    fun deleteAll()
}