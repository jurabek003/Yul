package com.jurabek888.yolharakatiqoidalari.Fragment

import android.os.Bundle
import android.os.UserHandle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jurabek888.yolharakatiqoidalari.Adapters.SecondFmAdapter
import com.jurabek888.yolharakatiqoidalari.Adapters.ThirdFmAdapter
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.MyObject
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private lateinit var thirdFmAdapter: ThirdFmAdapter
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    private val binding by lazy { FragmentThirdBinding.inflate(layoutInflater) }
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
        list.addAll(myDbHelper.getSpinner0(2))

        var name2: String
        var description2:String
        var imagepath2:String
        var spinner:Int



        if (!MyObject.name2.equals("") && !MyObject.name2.equals("") && !MyObject.name3.equals("") && MyObject.position==2){
            name2= MyObject.name2.toString()
            description2= MyObject.name2.toString()
            imagepath2= MyObject.name3.toString()
            spinner= MyObject.position
            MyObject.name2=""
            MyObject.name3=""
            MyObject.name3=""

            val user=User(name2,description2,imagepath2,spinner,0)
            list.addAll(listOf(user))
            myDbHelper.addItem(user)


        }

        thirdFmAdapter= ThirdFmAdapter(list)
        thirdFmAdapter.notifyDataSetChanged()
        binding.rv3.adapter=thirdFmAdapter

    }
}