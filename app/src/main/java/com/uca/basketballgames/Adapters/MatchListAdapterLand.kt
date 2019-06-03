package com.uca.basketballgames.Adapters

import android.content.Context
import android.service.autofill.FieldClassification
import android.support.v7.view.menu.ActionMenuItemView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.uca.basketballgames.Fragment.MatchFragment
import com.uca.basketballgames.R
import com.uca.basketballgames.Room.Entities.Partido

class MatchListAdapterLand internal constructor(context: Context) : RecyclerView.Adapter<MatchListAdapterLand.MatchViewHolder>(){
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var matches = emptyList<Partido>()
    private lateinit var fragmentManager: FragmentManager
    private lateinit var mainContentFragment: MatchFragment

    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val matchitemViewName1: TextView = itemView.findViewById(R.id.land_nombre_equipoA)
        val matchitemViewName2: TextView = itemView.findViewById(R.id.land_item_equipoB)
        val matchitemViewPuntaje1: TextView = itemView.findViewById(R.id.land_puntaje_EquipoA)
        val matchitemViewPuntaje2: TextView = itemView.findViewById(R.id.land_puntaje_EquipoB)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item2, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: MatchListAdapterLand.MatchViewHolder, position: Int) {
        val current = matches[position]

        mainContentFragment = MatchFragment.newInstance(
            Partido()
        )

        changeFragment(R.id.land_main_cont_fragment, mainContentFragment)
    }

    fun changeFragment(id: Int, frag: Fragment) {
        fragmentManager.beginTransaction().replace(id, frag).commit()
    }
    internal fun setMatches(matches: List<Partido>){
        this.matches = matches
        notifyDataSetChanged()
    }
    internal fun setManager(manager: FragmentManager){
        this.fragmentManager = manager
        notifyDataSetChanged()
    }

}