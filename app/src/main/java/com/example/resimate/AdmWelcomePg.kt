package com.example.resimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AdmWelcomePg : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adm_welcome_pg)

        val register=findViewById<ImageButton>(R.id.register)
        val complaints=findViewById<ImageButton>(R.id.complaints)
        val updateMenu=findViewById<ImageButton>(R.id.upadate_menu)
        val uploadnotice=findViewById<ImageButton>(R.id.upload_notice)


        register.setOnClickListener {
            startActivity(Intent(this,EnterStudent::class.java))
        }

        complaints.setOnClickListener {
            startActivity(Intent(this,ViewComplaints::class.java))
        }

        updateMenu.setOnClickListener {
            startActivity(Intent(this,UpdateMenu::class.java))
        }

        uploadnotice.setOnClickListener {
            startActivity(Intent(this,UploadNotice::class.java))
        }


    }
}