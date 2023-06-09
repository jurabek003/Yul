package com.jurabek888.yolharakatiqoidalari.Fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.jurabek888.yolharakatiqoidalari.Adapters.FirstFmAdabter
import com.jurabek888.yolharakatiqoidalari.Adapters.selectRoot
import com.jurabek888.yolharakatiqoidalari.DataBace.MyDbHelper
import com.jurabek888.yolharakatiqoidalari.Madels.MyObject
import com.jurabek888.yolharakatiqoidalari.Madels.User
import com.jurabek888.yolharakatiqoidalari.R
import com.jurabek888.yolharakatiqoidalari.RegisterActivity
import com.jurabek888.yolharakatiqoidalari.databinding.DialogItemBinding
import com.jurabek888.yolharakatiqoidalari.databinding.FirstFmItemBinding
import com.jurabek888.yolharakatiqoidalari.databinding.FragmentFirsBinding
import java.io.File
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class FirsFragment : Fragment() {
    private val binding by lazy { FragmentFirsBinding.inflate(layoutInflater) }
    private lateinit var firstFmAdabter: FirstFmAdabter
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var list: ArrayList<User>
    private lateinit var pathimega:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun loadData() {
        myDbHelper= MyDbHelper(binding.root.context)
        list=ArrayList()
        list.addAll(myDbHelper.getSpinner0(0))

        
        firstFmAdabter = FirstFmAdabter(list,object :selectRoot{

            val fmItemBinding=FirstFmItemBinding.inflate(layoutInflater)
            override fun select(position: Int, user: User) {
                //, bundleOf("key1" to user.name,"key2" to user.description, "key3" to user.imagePath
                findNavController().navigate(R.id.dicFragment)
            }

            override fun editItem(position: Int, user: User) {
            val dialog=BottomSheetDialog(binding.root.context)
                val dialogItemBinding=DialogItemBinding.inflate(layoutInflater)
                dialog.setContentView(dialogItemBinding.root)
                dialog.show()

                dialogItemBinding.edtItemName.setText(user.name)
                dialogItemBinding.edtItemDesciption.setText(user.description)
                dialogItemBinding.imgItm.setImageURI(Uri.parse(user.imagePath))

                dialogItemBinding.imgItm.setOnClickListener {
                    getImageContent.launch("image/*")
                }

                dialogItemBinding.btnSaveEdt.setOnClickListener {
                    user.name=dialogItemBinding.edtItemName.text.toString()
                    user.description=dialogItemBinding.edtItemDesciption.text.toString()
                    user.imagePath=pathimega
                    myDbHelper.editItem(user)
                    list[position] = user
                    firstFmAdabter.notifyItemChanged(position)
                    dialog.cancel()
                }
            }

            override fun deletItem(user: User, position: Int) {
                list.remove(user)
                myDbHelper.deletItem(user)
                firstFmAdabter.notifyItemRemoved(position)
                Toast.makeText(binding.root.context,"deleted", Toast.LENGTH_SHORT).show()
            }
        },binding.root.context)
        firstFmAdabter.notifyDataSetChanged()
        binding.rv1.adapter=firstFmAdabter

    }
    @SuppressLint("SimpleDateFormat")
    private val getImageContent=registerForActivityResult(ActivityResultContracts.GetContent()){
        it ?:return@registerForActivityResult
        val dialogItemBinding=DialogItemBinding.inflate(layoutInflater)
        dialogItemBinding.imgItm.setImageURI(it)
        val inputStream = requireContext().contentResolver.openInputStream(it)

        val name = SimpleDateFormat("yyyyMMdd_hh_mm_ss").format(Date())
        val file= File(requireContext().filesDir, "$name.jpg")
        val fileOutputStream= FileOutputStream(file)
        inputStream?.copyTo(fileOutputStream)
        inputStream?.close()
        fileOutputStream.close()
        pathimega= file.absolutePath


    }
}
