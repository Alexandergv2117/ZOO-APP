package com.example.zoo.UI.credits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.zoo.databinding.FragmentCreditsBinding
import com.example.zoo.utils.Const
import com.squareup.picasso.Picasso

class CreditsFragment : Fragment() {

    private var _binding: FragmentCreditsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val creditsViewModel =
            ViewModelProvider(this).get(CreditsViewModel::class.java)

        _binding = FragmentCreditsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        Picasso.get()
            .load("${Const.IMAGEN_CREDITS}")
            .into(binding.imageView)
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}