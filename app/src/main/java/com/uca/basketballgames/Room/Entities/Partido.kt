package com.uca.basketballgames.Room.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Match")
data class Partido (
    @PrimaryKey(autoGenerate = true) var idPartido: Long,
    @ColumnInfo(name = "Equipo1") var equipo1: String,
    @ColumnInfo(name = "Equipo2") var equipo2: String,
    @ColumnInfo(name = "Puntaje1") var puntos1: Int,
    @ColumnInfo(name = "Puntaje2") var puntos2: Int,
    @ColumnInfo(name = "Fecha_P") var FechaPartido: String,
    @ColumnInfo(name = "Hora_P") var HoraPartido: String
){
    constructor():
            this(0, "", "", 0, 0, "", "")
}