package com.example.resimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class termsNcondition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_terms_ncondition)

        val accept = findViewById<Button>(R.id.button)

        accept.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}