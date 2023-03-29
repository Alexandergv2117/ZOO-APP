package com.example.zoo.UI.Specie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.data.model.SpecieTypeModel

class SpecieTypeAdapter : RecyclerView.Adapter<SpecieTypeViewHolder>() {
    private val specieTypes = mutableListOf<SpecieTypeModel>()

    fun setList(specieTypeList: List<SpecieTypeModel>) {
        specieTypes.clear()
        specieTypes.addAll(specieTypeList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieTypeViewHolder {
        val context = parent.context
        val infater = LayoutInflater.from(context)
        val view = infater.inflate(R.layout.item_species, parent, false)
        return SpecieTypeViewHolder(view)
    }

    override fun getItemCount(): Int = specieTypes.size

    override fun onBindViewHolder(holder: SpecieTypeViewHolder, position: Int) {
        holder.bind(specieTypes[position])
    }
}