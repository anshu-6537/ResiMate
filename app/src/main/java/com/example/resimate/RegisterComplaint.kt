package com.example.resimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.firestore.FirebaseFirestore

class RegisterComplaint : AppCompatActivity() {


    var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stud_complaint)

        val arrDept = arrayOf("Electrical", "Carpentry", "Mess", "Sports", "Plumbing")
        var dept = ""
        db = FirebaseFirestore.getInstance()
        val spinnerDept = findViewById<Spinner>(R.id.deptSpinner)

        spinnerDept.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                dept = arrDept[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }

        val room = findViewById<EditText>(R.id.enter_room)
        val prob = findViewById<EditText>(R.id.related_prob)
        val desc = findViewById<EditText>(R.id.problem_desc)
        val Registerbtn = findViewById<Button>(R.id.register)

        Registerbtn.setOnClickListener {
            val Room = room.text.toString()
            val Prob = prob.text.toString()
            val Desc = desc.text.toString()
            val compMap: MutableMap<String,Any> = HashMap()
            compMap["Dept"]=dept
            compMap["Room"]=Room
            compMap["Prob"]=Prob
            compMap["Desc"]=Desc

            db!!.collection("Complaints")
                .add(compMap)
                .addOnSuccessListener {
                    Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }

        }
    }
}