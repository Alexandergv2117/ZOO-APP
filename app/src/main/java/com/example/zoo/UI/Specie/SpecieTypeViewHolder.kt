package com.example.zoo.UI.Specie

import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zoo.UI.home.HomeFragmentDirections
import com.example.zoo.data.model.SpecieTypeModel
import com.example.zoo.databinding.ItemSpeciesBinding
import com.example.zoo.utils.Const
import com.squareup.picasso.Picasso

class SpecieTypeViewHolder(
    private val itemView: View
): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSpeciesBinding.bind(itemView)

    fun bind(item: SpecieTypeModel) {
        binding.specieName.text = item.tipo
        Glide.with(itemView)
            .load(Const.BASE_URL_GOOGLE_DRIVE + item.link_foto)
            .into(binding.specieImage)
        itemView.setOnClickListener {
            val action = HomeFragmentDirections.actionNavigationHomeToListAnimalFragment(item.tipo)
            itemView.findNavController().navigate(action)
        }
    }
}