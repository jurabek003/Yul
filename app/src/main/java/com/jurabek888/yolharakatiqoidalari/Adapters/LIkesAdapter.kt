package com.jurabek888.yolharakatiqoidalari.Adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FirstFmItemBinding

class LIkesAdapter(val list: List<User>):RecyclerView.Adapter<LIkesAdapter.Vh>() {
    inner class Vh(val itemBinding: FirstFmItemBinding ):ViewHolder(itemBinding.root){
        fun onBind(user: User){
            itemBinding.item1Img.setImageURI(Uri.parse(user.imagePath))
            itemBinding.item1TitleName.text=user.name.toString()
            itemBinding.likeImg.setImageResource(R.drawable.red_likew)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FirstFmItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
      holder.onBind(list[position])
    }
}