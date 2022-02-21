package com.neppplus.librarypractice_20220221

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun setupEvents(){
//        버튼 이외의, TextView, ImageView 등도 setOnClickListener로 이벤트 처리가 가능함.
        imgProfile.setOnClickListener {

        }

        btnCall.setOnClickListener {
            val myUri = Uri.parse("tel:01033337777")
            val myIntent = Intent( Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }
    }
    fun setValues() {

    }
}