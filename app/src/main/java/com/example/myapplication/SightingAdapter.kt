package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Sighting

class SightingAdapter(private val sightingList: List<Sighting>) :
    RecyclerView.Adapter<SightingAdapter.SightingViewHolder>() {

    class SightingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.nameText)
        val typeText: TextView = itemView.findViewById(R.id.typeText)
        val locationText: TextView = itemView.findViewById(R.id.locationText)
        val dateText: TextView = itemView.findViewById(R.id.dateText)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SightingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sighting, parent, false)
        return SightingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SightingViewHolder, position: Int) {
        val sighting = sightingList[position]
        holder.nameText.text = sighting.speciesName
        holder.typeText.text = sighting.type
        holder.locationText.text = sighting.location
        holder.dateText.text = sighting.date
        holder.imageView.setImageResource(sighting.imageResId)
    }

    override fun getItemCount(): Int = sightingList.size
}
