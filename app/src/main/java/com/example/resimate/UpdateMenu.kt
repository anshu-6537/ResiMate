package com.example.resimate

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class UpdateMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_menu)

        val upload =findViewById<Button>(R.id.upimg)
//        val fetch=findViewById<Button>(R.id.fetchimg)

        upload.setOnClickListener {

            startActivity(Intent(this,uploadDocs::class.java))
        }


    }






}