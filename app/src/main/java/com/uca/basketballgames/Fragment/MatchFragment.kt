package com.uca.basketballgames.Fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.uca.basketballgames.R
import com.uca.basketballgames.Room.Entities.Partido
import kotlinx.android.synthetic.main.fragment_match.view.*

class MatchFragment : Fragment() {
    var match: Partido()

    companion object {
        @JvmStatic
        fun newInstance(match: Partido): MatchFragment{
            val newFragment = MatchFragment()
            newFragment.match = match
            return newFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_match, container, false)

        bindData(view)

        return view
    }

    fun bindData(view: View){
        view.Fecha_partido_fragment.text = match.FechaPartido
        view.Hora_Partido_fragment.text = match.HoraPartido
        view.nombre_equipoA_fragment.text = match.equipo1
        view.item_equipoB_fragment.text = match.equipo2
        view.puntaje_EquipoA_fragment.text = match.puntos1.toString()
        view.puntaje_EquipoB_fragment.text = match.puntos2.toString()
    }
}
