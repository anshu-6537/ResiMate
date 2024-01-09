package com.example.resimate

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.resimate.databinding.ActivityUploadDocsBinding
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.util.*

class uploadDocs : AppCompatActivity() {

    lateinit var binding: ActivityUploadDocsBinding
    lateinit var ImageUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityUploadDocsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_upload_docs)

        val selImg=findViewById<Button>(R.id.selImg)
        selImg.setOnClickListener {
            selectImg()
        }

        val upImg=findViewById<Button>(R.id.upImg)
        upImg.setOnClickListener {
            uploadImg()
        }
    }

    private fun selectImg() {

        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(
            Intent.createChooser(
                intent,
                "Select Picture"
            ),100
        )
    }

    private fun uploadImg() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading File...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val storage = FirebaseStorage.getInstance().getReference("images/menu")

        storage.putFile(ImageUri).
        addOnSuccessListener {

            binding.firebaseimg.setImageURI(null)
            Toast.makeText(this,"Successful",Toast.LENGTH_SHORT).show()
            if(progressDialog.isShowing)
                progressDialog.dismiss()
        }.addOnFailureListener {

            if(progressDialog.isShowing)
                progressDialog.dismiss()
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode==100 && resultCode== RESULT_OK)
        {
            ImageUri = data?.data!!
            binding.firebaseimg.setImageURI(ImageUri)
            Toast.makeText(this,"Successful", Toast.LENGTH_SHORT).show()
        }
    }
}