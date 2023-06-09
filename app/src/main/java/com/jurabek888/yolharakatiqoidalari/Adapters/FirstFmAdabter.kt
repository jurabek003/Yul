package com.jurabek888.yolharakatiqoidalari.Adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.databinding.FirstFmItemBinding

class FirstFmAdabter(val list: ArrayList<User>,val chekked: selectRoot,context: Context):RecyclerView.Adapter<FirstFmAdabter.Vh>() {
    val db= MyDbHelper(context)
    inner class Vh(val firstFmItemBinding: FirstFmItemBinding):ViewHolder(firstFmItemBinding.root){
        fun onBind(user: User,position: Int){

            firstFmItemBinding.item1TitleName.text=user.name.toString()
            firstFmItemBinding.item1Description.text=user.description.toString()
            firstFmItemBinding.item1Img.setImageURI(Uri.parse(user.imagePath))

            if (user.likee == 1){
                firstFmItemBinding.likeImg.setImageResource(R.drawable.red_likew)
            }else{
                firstFmItemBinding.likeImg.setImageResource(R.drawable.ic_like)
            }

            firstFmItemBinding.likeImg.setOnClickListener {
                if(user.likee !=1 ){
                   firstFmItemBinding.likeImg.setImageResource(R.drawable.red_likew)
                    user.likee = 1
                    db.addLikeChekked(user)
                }else if( user.likee != 0 ){
                     firstFmItemBinding.likeImg.setImageResource(R.drawable.ic_like)
                    user.likee = 0
                    db.addLikeChekked(user)
                }
            }

            firstFmItemBinding.root.setOnClickListener {
                chekked.select(position,user)
            }

            firstFmItemBinding.item1Edit.setOnClickListener {
                chekked.editItem(position,user)
            }
            firstFmItemBinding.item1Delet.setOnClickListener {
                chekked.deletItem(user,position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FirstFmItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position],position)
    }

}
interface selectRoot{
    fun select(position: Int,user: User )
   fun editItem(position: Int, user: User)
   fun deletItem(user: User,position: Int)
}