package com.example.zoo.UI.ListAnimal

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.zoo.R
import com.example.zoo.UI.Animal.AnimalTypeAdapter
import com.example.zoo.UI.Animal.AnimalTypeViewModel
import com.example.zoo.databinding.FragmentListAnimalBinding
import com.example.zoo.utils.Const
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListAnimalFragment : Fragment() {
    private val args by navArgs<ListAnimalFragmentArgs>()
    private var _binding: FragmentListAnimalBinding? = null
    private val binding get() = _binding!!
    private val animalViewModel: AnimalTypeViewModel by viewModels()

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
        setHasOptionsMenu(true)
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.nav_view)

        // Cambiar el nombre de la toolbar
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = args.tipo
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        bottomNavigationView?.visibility = View.GONE
        setList(view)
        configSwipe()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                requireActivity().onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("ResourceAsColor")
    private fun configSwipe() {
        binding.swipeHome.setOnRefreshListener {
            binding.swipeHome.setColorSchemeColors(R.color.white, R.color.teal_200)
            val layoutManager = GridLayoutManager(requireContext(), 2)

            animalViewModel.onReload(
                layoutManager,
                binding.recyclerView,
                AnimalTypeAdapter(),
                args.tipo
            )

            Handler(Looper.getMainLooper()).postDelayed(
                { binding.swipeHome.isRefreshing = false },
                Const.TIMEOUT
            )
        }
    }

    private fun setList(view: View) {
        animalViewModel.onCreate(
            AnimalTypeAdapter(),
            view,
            requireContext(),
            args.tipo
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}