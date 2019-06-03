package com.uca.basketballgames.Model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uca.basketballgames.Repository.MatchRepository
import com.uca.basketballgames.Room.Database.MatchesDB
import com.uca.basketballgames.Room.Entities.Partido
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MatchViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MatchRepository
    val allMatches: LiveData<List<Partido>>

    init {
        val matchDao = MatchesDB.getInstance(application).partidoDAO()
        repository = MatchRepository(matchDao)
        allMatches = repository.allMatches

    }

    fun insertMatches(partido: Partido) = viewModelScope.launch(Dispatchers.IO) {
        repository.insertMatch(partido)
    }
}