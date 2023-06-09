package com.jurabek888.yolharakatiqoidalari.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jurabek888.yolharakatiqoidalari.Adapters.LIkesAdapter
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentLikeBinding

class LikeFragment : Fragment() {
    private val binding  by lazy { FragmentLikeBinding.inflate(layoutInflater) }
    private lateinit var lIkesAdapter: LIkesAdapter
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }
    private fun loadData() {
        myDbHelper= MyDbHelper(binding.root.context)
        list=ArrayList()
        list.addAll(myDbHelper.getLikeItem(1))
        lIkesAdapter=LIkesAdapter(list)
        binding.rv5.adapter=lIkesAdapter
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding.cancelButton3.setOnClickListener {
            findNavController().navigate(R.id.homeFragment)
        }


        return binding.root
    }
}