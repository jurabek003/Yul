package com.jurabek888.yolharakatiqoidalari.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jurabek888.yolharakatiqoidalari.Adapters.FourFMAdapter
import com.jurabek888.yolharakatiqoidalari.Adapters.ThirdFmAdapter
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.MyObject
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentFirsBinding
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentFourBinding

class FourFragment : Fragment() {
    private lateinit var fourFMAdapter: FourFMAdapter
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

    }
    private val binding by lazy { FragmentFourBinding.inflate(layoutInflater) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return binding.root
    }
    private fun loadData() {
        myDbHelper= MyDbHelper(binding.root.context)
        list = ArrayList()
        list.addAll(myDbHelper.getSpinner0(3))

        var name2: String
        var description2:String
        var imagepath2:String
        var spinner:Int
        var likePath:Int
        if (!MyObject.name2.equals("") && !MyObject.name2.equals("") && !MyObject.name3.equals("") && MyObject.position==3){
            name2= MyObject.name2.toString()
            description2= MyObject.name2.toString()
            imagepath2= MyObject.name3.toString()
            spinner= MyObject.position


            MyObject.name2=""
            MyObject.name3=""
            MyObject.name3=""

            val user=User(name2,description2,imagepath2,spinner,0,)
            list.addAll(listOf(user))
            myDbHelper.addItem(user)


        }

        fourFMAdapter= FourFMAdapter(list)
        fourFMAdapter.notifyDataSetChanged()
        binding.rv4.adapter=fourFMAdapter

    }
}