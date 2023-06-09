package com.jurabek888.yolharakatiqoidalari.DataBace
import com.jurabek888.yolharakatiqoidalari.Madels.User

interface MyDbInterfase {

    fun addItem(user: User)
    fun getItem():ArrayList<User>
    fun getSpinner0(id:Int): ArrayList<User>
    fun addLikeChekked(user: User)
    fun getLikeItem(likes:Int):ArrayList<User>
    fun editItem(user: User)
    fun deletItem(user:User)




}