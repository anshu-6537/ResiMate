package com.example.resimate

import android.app.ProgressDialog
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.example.resimate.databinding.ActivityViewMenuBinding
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class ViewMenu : AppCompatActivity() {

    lateinit var binding : ActivityViewMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewMenuBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_view_menu)

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Fetching Image....")
        progressDialog.setCancelable(false)

        val display = findViewById<ImageView>(R.id.displayImg)
        val fetchImg=findViewById<Button>(R.id.fetch)
        fetchImg.setOnClickListener {

            progressDialog.show()

            val storage = FirebaseStorage.getInstance().reference.child("images/menu")

            val localfile = File.createTempFile("tempImage","jpeg")
            storage.getFile(localfile).addOnSuccessListener {

                if(progressDialog.isShowing)
                    progressDialog.dismiss()
                val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
                display.setImageBitmap(bitmap)

            }.addOnFailureListener {

                if(progressDialog.isShowing)
                    progressDialog.dismiss()
                Toast.makeText(this,"Failes to fetch the Image", Toast.LENGTH_SHORT).show()

            }


        }

    }
}