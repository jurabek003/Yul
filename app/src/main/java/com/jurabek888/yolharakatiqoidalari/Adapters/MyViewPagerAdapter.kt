package com.jurabek888.yolharakatiqoidalari.Adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jurabek888.yolharakatiqoidalari.Fragment.FirsFragment
import com.jurabek888.yolharakatiqoidalari.Fragment.FourFragment
import com.jurabek888.yolharakatiqoidalari.Fragment.SecondFragment
import com.jurabek888.yolharakatiqoidalari.Fragment.ThirdFragment

@Suppress("DEPRECATION")
class MyViewPagerAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {

        return when(position) {
            0-> FirsFragment()
            1-> SecondFragment()
            2-> ThirdFragment()
            3-> FourFragment()
            else -> FirsFragment()
        }
    }

}