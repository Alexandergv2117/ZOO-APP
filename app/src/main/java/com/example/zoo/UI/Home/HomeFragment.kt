package com.example.zoo.UI.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
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
        progressBar()
        configSwipe()
    }

    @SuppressLint("ResourceAsColor")
    private fun configSwipe() {
        binding.swipeHome.setOnRefreshListener {
            binding.swipeHome.setColorSchemeColors(R.color.white, R.color.teal_200)
            val layoutManager = LinearLayoutManager(requireContext())
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

    private fun progressBar() {
        specieViewModel.isLoanding.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}