package com.example.zoo.UI.Specie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.databinding.ItemSpeciesBinding

class SpecieTypeViewHolder(
    private val itemView: View
): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSpeciesBinding.bind(itemView)

    fun bind(item: SpecieTypeModel) {
        binding.specieId.text = item.id.toString()
        binding.specieName.text = item.tipo
        Glide.with(itemView.context).load(item.link_foto).into(binding.specieImage)
    }
}