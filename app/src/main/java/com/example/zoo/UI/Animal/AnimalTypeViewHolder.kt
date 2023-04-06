package com.example.zoo.UI.Animal

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.zoo.data.model.AnimalTypeModel
import com.example.zoo.databinding.ItemAnimalBinding
import com.example.zoo.utils.Const
import com.squareup.picasso.Picasso

class AnimalTypeViewHolder(
    private val itemView: View
): RecyclerView.ViewHolder(itemView) {
    private val binding = ItemAnimalBinding.bind(itemView)

    fun bind(item: AnimalTypeModel) {
        binding.animalName.text = item.scientific_name
        Picasso.get()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${item.imagen}")
            .into(binding.animalImage)

        itemView.setOnClickListener {
            Toast.makeText(itemView.context, "Animal: ${item.scientific_name}", Toast.LENGTH_SHORT).show()
        }
    }
}