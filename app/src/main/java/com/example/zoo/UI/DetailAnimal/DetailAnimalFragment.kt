package com.example.zoo.UI.DetailAnimal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.zoo.databinding.FragmentDetailAnimalBinding
import com.example.zoo.utils.Const
import com.squareup.picasso.Picasso

class DetailAnimalFragment : Fragment() {

    private val args by navArgs<DetailAnimalFragmentArgs>()
    private var _binding: FragmentDetailAnimalBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Picasso.get()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${args.animalType.imagen}")
            .into(binding.gifAnimal)

        binding.nombreCientifico.text = args.animalType.scientific_name
        binding.nombre.text = args.animalType.nombre
        binding.textOrigen.text = args.animalType.origen
        binding.textHabitat.text = args.animalType.habitat
        binding.textRiesgo.text = args.animalType.riesgo
        binding.textTamanio.text = args.animalType.tamanio
        binding.textReproduccion.text = args.animalType.reproduccion
        binding.textAlimentacion.text = args.animalType.alimentacion
        binding.descripcion.text = args.animalType.descripcion

        Picasso.get()
            .load("${Const.BASE_URL_GOOGLE_DRIVE}${args.animalType.imagen}")
            .into(binding.mapa)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}