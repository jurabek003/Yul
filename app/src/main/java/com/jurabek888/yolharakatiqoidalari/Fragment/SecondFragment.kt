package com.jurabek888.yolharakatiqoidalari.Fragment

import android.os.Bundle
import android.os.UserHandle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jurabek888.yolharakatiqoidalari.Adapters.SecondFmAdapter
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.MyObject
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var secondFmAdapter: SecondFmAdapter
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }
    private val binding by lazy { FragmentSecondBinding.inflate(layoutInflater) }
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
        list.addAll(myDbHelper.getSpinner0(1))

        var name1: String
        var description1:String
        var imagepath1:String
        var spinner:Int

        val likePath:Int

        if (!MyObject.name1.equals("") && !MyObject.name2.equals("") && !MyObject.name3.equals("") && MyObject.position==1){
            name1=MyObject.name1.toString()
            description1=MyObject.name2.toString()
            imagepath1=MyObject.name3.toString()
            spinner=MyObject.position

            MyObject.name2=""
            MyObject.name3=""
            MyObject.name3=""

            val user=User(name1,description1,imagepath1,spinner,0,)
            list.addAll(listOf(user))
            myDbHelper.addItem(user)

        }

        secondFmAdapter= SecondFmAdapter(list)
        binding.rv2.adapter=secondFmAdapter
        secondFmAdapter.notifyDataSetChanged()

    }
}