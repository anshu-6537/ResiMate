package com.example.resimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore


class UploadNotice : AppCompatActivity() {

    var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_notice)

        db = FirebaseFirestore.getInstance()

        val title = findViewById<EditText>(R.id.enter_title)
        val desc = findViewById<EditText>(R.id.notice_desc)
        val Registerbtn = findViewById<Button>(R.id.register)


        Registerbtn.setOnClickListener {
            val Title = title.text.toString()
            val Desc = desc.text.toString()
            val compMap: MutableMap<String, Any> = HashMap()
            compMap["Title"] = Title
            compMap["Desc"] = Desc
            compMap["val"]=1

            db!!.collection("Notices")
                .add(compMap)
                .addOnSuccessListener {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }

        }
    }
}