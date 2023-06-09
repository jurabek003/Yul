package com.jurabek888.yolharakatiqoidalari

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Fragment.HomeFragment
import com.jurabek888.yolharakatiqoidalari.Madels.MyObject
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.databinding.ActivityRegisterBinding
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.Date

class RegisterActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRegisterBinding.inflate(layoutInflater) }
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        myDbHelper=MyDbHelper(this)
        list= ArrayList()
        binding.selectImage.setOnClickListener {
            getImageContent.launch("image/*")
        }
        binding.cancelButton.setOnClickListener {
            val intent=Intent(this,HomeFragment::class.java)
            startActivity(intent)
            finishAffinity()
        }
        binding.btnSave.setOnClickListener {
            if (pathIMage != ""){
                val user=User(binding.edtName.text.toString(),binding.edtDescription.text.toString(),pathIMage,binding.itemSpinner.selectedItemPosition,0)
                myDbHelper.addItem(user)
                }
            }
        }
    var pathIMage=""
    @SuppressLint("SimpleDateFormat")
    private val getImageContent=registerForActivityResult(ActivityResultContracts.GetContent()){
        it ?:return@registerForActivityResult
        binding.selectImage.setImageURI(it)
        val inputStream=contentResolver.openInputStream(it)

        val name = SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(Date())
        val file=File(filesDir, "$name.jpg")
        val fileOutputStream=FileOutputStream(file)
        inputStream?.copyTo(fileOutputStream)
        inputStream?.close()
        fileOutputStream.close()
        pathIMage = file.absolutePath

    }
}