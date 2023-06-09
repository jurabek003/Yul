package com.jurabek888.yolharakatiqoidalari.Adapters
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.databinding.FirstFmItemBinding

class FourFMAdapter(val list: List<User>) :
    RecyclerView.Adapter<FourFMAdapter.Vh>() {
    inner class Vh(val itemRV: FirstFmItemBinding) : ViewHolder(itemRV.root) {
        fun onBind(user: User) {
            itemRV.item1TitleName.text = user.name.toString()
            itemRV.item1Description.text = user.description.toString()
            itemRV.item1Img.setImageURI(Uri.parse(user.imagePath))
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
