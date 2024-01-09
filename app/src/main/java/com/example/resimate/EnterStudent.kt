package com.example.resimate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.firebase.firestore.FirebaseFirestore

class EnterStudent : AppCompatActivity() {

    var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter_student)
        db = FirebaseFirestore.getInstance()
        val name = findViewById<EditText>(R.id.edit_name)
        val branch = findViewById<EditText>(R.id.edit_branch)
        val roomNo = findViewById<EditText>(R.id.edit_room_no)
        val age = findViewById<EditText>(R.id.edit_age)

        val Registerbtn = findViewById<Button>(R.id.btnRegister)
        Registerbtn.setOnClickListener {
            val Name = name.getText().toString()
            val Branch = branch.getText().toString()
            val Age = age.getText().toString()
            val room_no = roomNo.getText().toString()
            val user: MutableMap<String, Any> = HashMap()
            user["Name"] = Name
            user["Age"] = Age
            user["Branch"] = Branch
            user["Room"] = room_no
            db!!.collection("user")
                .add(user)
                .addOnSuccessListener {
                    Toast.makeText(
                        this@EnterStudent,
                        "Successful",
                        Toast.LENGTH_SHORT
                    ).show()
                }.addOnFailureListener {
                    Toast.makeText(
                        this@EnterStudent,
                        "Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
    }
}