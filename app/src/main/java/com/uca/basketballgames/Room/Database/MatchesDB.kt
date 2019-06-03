package com.uca.basketballgames.Room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uca.basketballgames.Room.Dao.PartidoDAO
import com.uca.basketballgames.Room.Entities.Partido

@Database(entities = [Partido::class], version = 1)
abstract class MatchesDB : RoomDatabase(){

    abstract fun partidoDAO(): PartidoDAO

    companion object {
        @Volatile
        private var INSTANCE: MatchesDB? = null

        fun getInstance(AppContext: Context): MatchesDB{
            val tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this){
                val instance = Room
                    .databaseBuilder(AppContext, MatchesDB::class.java,"Match_DB")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}