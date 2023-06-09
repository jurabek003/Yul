package com.jurabek888.yolharakatiqoidalari.DataBace

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jurabek888.yolharakatiqoidalari.Madels.User

class MyDbHelper(context: Context):
    SQLiteOpenHelper(context,"$DB_NAME",null, VERSION),MyDbInterfase {

    companion object{
        const val DB_NAME="jurabek"
        const val VERSION=1
        const val ID="id"
        const val TABLE_NAME="table_name"
        const val NAME="name"
        const val DESCRIPTION="description"
        const val IMAGEPATH="imagePath"
        const val SPINNER="spinner"
        const val LIKEE="likee"

    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val query="create table $TABLE_NAME($ID integer not null primary key autoincrement unique,$NAME " +
                "text not null,$DESCRIPTION text not null,$IMAGEPATH text not null, $SPINNER  integer not null,  $LIKEE integer not null)"

        p0?.execSQL(query)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun addItem(user: User) {
        val database=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(NAME,user.name)
        contentValues.put(DESCRIPTION,user.description)
        contentValues.put(IMAGEPATH,user.imagePath)
        contentValues.put(SPINNER,user.sppiner)
        contentValues.put(LIKEE,user.likee)
        database.insert(TABLE_NAME,null,contentValues)
        database.close()

    }

    override fun getItem(): ArrayList<User> {
     val database=readableDatabase
        val list=ArrayList<User>()
        val query="select *from $TABLE_NAME"
        val cursor=database.rawQuery(query,null)
        if (cursor.moveToFirst()){
            do {
                list.add(
                    User(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getInt(5),

                    )
                )
            }while (cursor.moveToNext())
        }

        return list
    }

    @SuppressLint("Range")
    override fun getSpinner0(id: Int): ArrayList<User> {
        val list=ArrayList<User>()
        val data=readableDatabase
        val query="select *FROM $TABLE_NAME where $SPINNER = ?"
        val cursor = data.rawQuery(query,arrayOf(id.toString()), null)
        if (cursor.moveToFirst()){
            do {
              list.add(User(
                  cursor.getInt(0),
                  cursor.getString(1),
                  cursor.getString(2),
                  cursor.getString(3),
                  cursor.getInt(4),
                  cursor.getInt(5),

              ))
            }while (cursor.moveToNext())
        }
        return list
    }

    override fun addLikeChekked(user: User) {
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(LIKEE,user.likee)

        db.update(TABLE_NAME,contentValues, "$ID = ?", arrayOf(user.id.toString()))
        db.close()
    }

    override fun getLikeItem(likes: Int): ArrayList<User> {
        val db=readableDatabase
        val list=ArrayList<User>()
        val query="select *from $TABLE_NAME where $LIKEE = ? "
        val cursor=db.rawQuery(query, arrayOf(likes.toString()),null )
        if (cursor.moveToFirst()){
            do {
                list.add(User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getInt(5)
                ))
            }while (cursor.moveToNext())
        }
        return list
    }

    override fun editItem(user: User) {
        val db=writableDatabase
        val contentValues=ContentValues()
        contentValues.put(NAME,user.name)
        contentValues.put(DESCRIPTION,user.description)
        contentValues.put(IMAGEPATH,user.imagePath)
        contentValues.put(SPINNER,user.sppiner)
        contentValues.put(LIKEE,user.likee)
        db.update(TABLE_NAME, contentValues, "$ID = ?", arrayOf(user.id.toString()))
        db.close()
    }

    override fun deletItem(user: User ) {
        val db=writableDatabase
        db.delete(TABLE_NAME,"$ID=?", arrayOf(user.id.toString()))
        db.close()
    }

}