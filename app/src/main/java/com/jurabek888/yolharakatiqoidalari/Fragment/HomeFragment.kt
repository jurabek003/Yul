package com.jurabek888.yolharakatiqoidalari.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jurabek888.yolharakatiqoidalari.Adapters.MyViewPagerAdapter
import com.jurabek888.yolharakatiqoidalari.Madels.MyNote
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.RegisterActivity
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentHomeBinding
import com.jurabek888.yolharakatiqoidalari.databinding.TabItemBinding


class HomeFragment : Fragment() {
    private val binding by lazy { FragmentHomeBinding.inflate(layoutInflater) }
    private lateinit var myViewPagerAdapter: MyViewPagerAdapter
    private lateinit var list: ArrayList<MyNote>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         try {
             myViewPagerAdapter = MyViewPagerAdapter(requireActivity())
             binding.viewPager.adapter = myViewPagerAdapter
             btnNAvigation()
             if (savedInstanceState != null) {
                 binding.viewPager.adapter=(null);
                 binding.viewPager.adapter=(myViewPagerAdapter);
             }
         }catch (e:IllegalStateException){
             myViewPagerAdapter = MyViewPagerAdapter(requireActivity())
             binding.viewPager.adapter = myViewPagerAdapter
         }
    }

    private fun btnNAvigation() {
        binding.btnNavigation.setOnItemSelectedListener{
            when(it.itemId){
                R.id.like->{
                    findNavController().navigate(R.id.likeFragment)
                    true
                }
                R.id.home->{
                    findNavController().navigate(R.id.homeFragment)
                    true
                }else ->{
                findNavController().navigate(R.id.aboutFragment)
                    true
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding.imgAdd.setOnClickListener {
            val intent = Intent(binding.root.context, RegisterActivity::class.java)
            startActivity(intent)
        }

       TabLayoutMediator(binding.tabLayout,binding.viewPager,){tab, position->
           //tab.text=list[position].title
       }.attach()

        listData()
        
        val tabCount = binding.tabLayout.tabCount
        for (i in 0 until tabCount) {
            val tabItemBinding = TabItemBinding.inflate(layoutInflater)
            val tab = binding.tabLayout.getTabAt(i)
            tabItemBinding.tabTitle.text = list[i].title.toString()
            tab?.customView = tabItemBinding.root
        }

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabItemBinding = TabItemBinding.inflate(layoutInflater)
                tabItemBinding.laynerTab.setBackgroundResource(R.color.purple_200)
                tabItemBinding.tabTitle.text = list[tab?.position!!].title

                tab?.setCustomView(tabItemBinding.root)
            }

            @SuppressLint("ResourceAsColor")
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabItemBinding = TabItemBinding.inflate(layoutInflater)
                tabItemBinding.tabTitle.text = list[tab?.position!!].title
                tab?.setCustomView(tabItemBinding.root)

            }

            @SuppressLint("ResourceAsColor")
            override fun onTabReselected(tab: TabLayout.Tab?) {
                val tabItemBinding = TabItemBinding.inflate(layoutInflater)
                tabItemBinding.laynerTab.setBackgroundColor(R.color.white)
                tabItemBinding.tabTitle.text = list[tab?.position!!].title
                tab?.setCustomView(tabItemBinding.root)
            }

        })


        return binding.root
    }
    private fun listData() {
        list=ArrayList()
        list.add(MyNote("Ogohlantiruvchi"))
        list.add(MyNote("Imtiyozli"))
        list.add(MyNote("Ta'qiqlovchi"))
        list.add(MyNote("Buyuruvchi"))

    }
}
