package com.jurabek888.yolharakatiqoidalari.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private val binding by lazy { FragmentAboutBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding.cancelButton4.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }



        return binding.root
    }
}