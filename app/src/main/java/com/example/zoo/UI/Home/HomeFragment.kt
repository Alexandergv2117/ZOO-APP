package com.example.zoo.UI.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zoo.R
import com.example.zoo.UI.Specie.SpecieTypeAdapter
import com.example.zoo.UI.Specie.SpecieTypeViewModel
import com.example.zoo.databinding.FragmentHomeBinding
import com.example.zoo.utils.Const
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val specieViewModel: SpecieTypeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setList(view)
        configSwipe()
    }

    @SuppressLint("ResourceAsColor")
    private fun configSwipe() {
        binding.swipeHome.setOnRefreshListener {
            binding.swipeHome.setColorSchemeColors(R.color.white, R.color.teal_200)
            val layoutManager = GridLayoutManager(requireContext(), 2)
            val itemDecorator =
                DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)

            specieViewModel.onReload(
                layoutManager,
                itemDecorator,
                binding.recyclerView,
                SpecieTypeAdapter()
            )

            Handler(Looper.getMainLooper()).postDelayed(
                { binding.swipeHome.isRefreshing = false },
                Const.TIMEOUT
            )
        }
    }

    private fun setList(view: View) {
        specieViewModel.onCreate(
            SpecieTypeAdapter(),
            view,
            requireContext()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}