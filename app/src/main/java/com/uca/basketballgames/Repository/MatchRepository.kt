package com.uca.basketballgames.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.uca.basketballgames.Room.Dao.PartidoDAO
import com.uca.basketballgames.Room.Entities.Partido

class MatchRepository(private val partidoDao: PartidoDAO) {
    val allMatches: LiveData<List<Partido>> = partidoDao.getAllPartidos()

    @WorkerThread
    suspend fun insertMatch(partido: Partido){
        partidoDao.insert(partido)
    }
}