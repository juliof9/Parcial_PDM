package com.uca.basketballgames.Adapters

import android.content.Context
import android.service.autofill.FieldClassification
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uca.basketballgames.R
import com.uca.basketballgames.Room.Entities.Partido

class MatchListAdapter internal constructor(context: Context) : RecyclerView.Adapter<MatchListAdapter.MatchViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var Matches = emptyList<Partido>()

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val matchitemViewequipoA: TextView = itemView.findViewById(R.id.nombre_equipoA)
        val matchitemViewpuntajeA: TextView = itemView.findViewById(R.id.puntaje_EquipoA)
        val matchitemViewFecha: TextView = itemView.findViewById(R.id.Fecha_partido)
        val matchitemViewHora: TextView = itemView.findViewById(R.id.Hora_Partido)
        val matchitemViewpuntajeB: TextView = itemView.findViewById(R.id.puntaje_EquipoB_)
        val matchitemViewequipoB: TextView = itemView.findViewById(R.id.item_equipoB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun getItemCount()= Matches.size

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val current = Matches[position]
        holder.matchitemViewpuntajeA.text = current.puntos1.toString()
        holder.matchitemViewpuntajeB.text = current.puntos2.toString()
        holder.matchitemViewequipoA.text = current.equipo1
        holder.matchitemViewFecha.text = current.FechaPartido
        holder.matchitemViewHora.text = current.HoraPartido
        holder.matchitemViewequipoB.text = current.equipo2
    }

    internal fun setMatches(matches: List<Partido>){
        this.Matches = matches
        notifyDataSetChanged()
    }
}