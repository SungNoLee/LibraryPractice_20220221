package com.neppplus.librarypractice_20220221

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    fun setupEvents(){
//        버튼 이외의, TextView, ImageView 등도 setOnClickListener로 이벤트 처리가 가능함.
        imgProfile.setOnClickListener {

        }

        btnCall.setOnClickListener {
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                        승인이 OK 일때 할 행동
                    val myUri = Uri.parse("tel:01033337777")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
//                거절었을때 할 행동
                    Toast.makeText(this@MainActivity, "권한이 거절되어 통화가 불가능합니다.", Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }
    fun setValues() {

    }
}