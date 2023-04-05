package com.example.zoo.UI.ListAnimal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.zoo.R
import com.example.zoo.databinding.FragmentListAnimalBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ListAnimalFragment : Fragment() {
    private val args by navArgs<ListAnimalFragmentArgs>()
    private var _binding: FragmentListAnimalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListAnimalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.text.text = args.tipo
    }
}