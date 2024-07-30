package com.nyonz.restcountriesapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CountryAdapter(private val countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryName: TextView = itemView.findViewById(R.id.countryName)
        val countryCapital: TextView = itemView.findViewById(R.id.countryCapital)
        val countryRegion: TextView = itemView.findViewById(R.id.countryRegion)
        val countryPopulation: TextView = itemView.findViewById(R.id.countryPopulation)
        val countryFlag: ImageView = itemView.findViewById(R.id.countryFlag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val currentCountry = countryList[position]

        holder.countryName.text = currentCountry.name.common ?: "Unknown"

        holder.countryCapital.text = currentCountry.capital?.joinToString(", ") ?: "No capital"

        holder.countryRegion.text = currentCountry.region ?: "Unknown region"

        holder.countryPopulation.text = currentCountry.population?.toString() ?: "Unknown population"

        Glide.with(holder.itemView.context)
            .load(currentCountry.flags?.png ?: "")
            .into(holder.countryFlag)
    }

    override fun getItemCount() = countryList.size
}
