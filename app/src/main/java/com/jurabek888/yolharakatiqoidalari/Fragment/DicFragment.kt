package com.jurabek888.yolharakatiqoidalari.Fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentDicBinding

class DicFragment : Fragment() {
    private val binding by lazy { FragmentDicBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val nameDic=arguments?.getString("key1").toString()
        val description=arguments?.getString("key2").toString()
        val img=arguments?.getString("key3").toString()

        binding.replaseName.text=nameDic.toString()
        binding.replaseImg.setImageURI(Uri.parse(img))
        binding.replaseTht.text=description.toString()


        binding.cancelButton2.setOnClickListener {
            val homeFragment=HomeFragment()
            parentFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.)
          ///  findNavController().popBackStack()
        }


        return binding.root
    }
}