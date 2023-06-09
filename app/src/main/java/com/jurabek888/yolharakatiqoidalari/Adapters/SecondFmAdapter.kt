package com.jurabek888.yolharakatiqoidalari.Adapters
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.databinding.FirstFmItemBinding

class SecondFmAdapter(val list: List<User>) :
    RecyclerView.Adapter<SecondFmAdapter.Vh>() {
    inner class Vh(val itemRv: FirstFmItemBinding) : ViewHolder(itemRv.root) {
        fun onBind(userGuruh: User) {
            itemRv.item1TitleName.text=userGuruh.name.toString()
            itemRv.item1Description.text=userGuruh.description.toString()
            itemRv.item1Img.setImageURI(Uri.parse(userGuruh.imagePath))
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(FirstFmItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

}