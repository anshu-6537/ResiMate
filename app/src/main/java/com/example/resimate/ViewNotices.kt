package com.example.resimate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class ViewNotices : AppCompatActivity() {

    lateinit var newRecyclerView: RecyclerView
    var db: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_notices)


        val list = ArrayList<CollegeNotice>()
        db = FirebaseFirestore.getInstance()

        db!!.collection("Notices")
            .whereEqualTo("val", 1)
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Successfull", Toast.LENGTH_LONG).show()
                    for (document in task.result) {
                        list.add(
                            CollegeNotice(
                                document.get("Title") as String,
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

                newRecyclerView.adapter = NoticeAdapter(list)
            }

    }
}