package com.example.resimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ViewComplaints : AppCompatActivity() {

    lateinit var newRecyclerView: RecyclerView
    var db: FirebaseFirestore? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_complaints)

        val viewBtn = findViewById<Button>(R.id.viewBtn)

        val arrDept = arrayOf("Electrical", "Carpentry", "Mess", "Sports", "Plumbing")
        var dept = ""

        val spinnerDept = findViewById<Spinner>(R.id.deptspinner)

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

        val list = ArrayList<StudentComplaints>()
        db = FirebaseFirestore.getInstance()
        viewBtn.setOnClickListener {

//            Toast.makeText(this, "$floor-$room", Toast.LENGTH_SHORT).show()

            db!!.collection("Complaints")
                .whereEqualTo("Dept", dept)
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Successful", Toast.LENGTH_LONG).show()
                        for (document in task.result) {

                            list.add(
                                StudentComplaints(
                                    document.get("Dept") as String,
                                    document.get("Room") as String,
                                    document.get("Prob") as String,
                                    document.get("Desc") as String,
                                )
                            )
                        }
                    } else {
                        Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
                    }

                    newRecyclerView = findViewById(R.id.recyclerView)
                    newRecyclerView.layoutManager = LinearLayoutManager(this)
                    newRecyclerView.setHasFixedSize(true)

                    newRecyclerView.adapter = ComplaintsAdapter(list)
                }
        }
    }
}