package com.example.zoo.UI.Specie

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.databinding.ItemSpeciesBinding
import com.example.zoo.utils.Const
import com.squareup.picasso.Picasso

class SpecieTypeViewHolder(
    private val itemView: View
): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSpeciesBinding.bind(itemView)

    fun bind(item: SpecieTypeModel) {
        binding.specieId.text = item.id.toString()
        binding.specieName.text = item.tipo
        Picasso.get()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${item.link_foto}")
            .into(binding.specieImage)
    }
}