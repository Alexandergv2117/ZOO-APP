package com.example.zoo.UI.Animal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.R
import com.example.zoo.data.model.AnimalTypeModel

class AnimalTypeAdapter: RecyclerView.Adapter<AnimalTypeViewHolder>() {
    private val animalTypes = mutableListOf<AnimalTypeModel>()

    fun setList(animalTypeList: List<AnimalTypeModel>) {
        animalTypes.clear()
        animalTypes.addAll(animalTypeList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalTypeViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_animal, parent, false)
        return AnimalTypeViewHolder(view)
    }

    override fun getItemCount(): Int = animalTypes.size

    override fun onBindViewHolder(holder: AnimalTypeViewHolder, position: Int) {
        holder.bind(animalTypes[position])
    }
}