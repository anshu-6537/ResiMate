package com.example.resimate

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity


class StudWelcomePg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stud_welcome_pg)

        val grid = findViewById<GridView>(R.id.idGVcourses)
        val courseModelArrayList: ArrayList<ItemModel> = ArrayList()

        courseModelArrayList.add(ItemModel("Room Enquiry", R.drawable.student))
        courseModelArrayList.add(ItemModel("Hostel Menu", R.drawable.admin))
        courseModelArrayList.add(ItemModel("Complaints", R.drawable.complaint))
        courseModelArrayList.add(ItemModel("Notices", R.drawable.notices))
        courseModelArrayList.add(ItemModel("Help", R.drawable.help))
//        courseModelArrayList.add(CourseModel("DSA", R.drawable.ic_gfglogo))

        val adapter = GridAdapter(this, courseModelArrayList)
        grid.adapter = adapter


        grid.setOnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this, RoomPreview::class.java))
                1 -> startActivity(Intent(this, ViewMenu::class.java))
                2 -> startActivity(Intent(this, RegisterComplaint::class.java))
                3 -> startActivity(Intent(this, ViewNotices::class.java))

            }
        }
    }
}

//        val room = findViewById<ImageButton>(R.id.rooms)
//        val menu = findViewById<ImageButton>(R.id.menu)
//        val complain = findViewById<ImageButton>(R.id.complaint)
//
//        room.setOnClickListener {
//            startActivity(Intent(this,RoomPreview::class.java))
//        }
//
//        complain.setOnClickListener {
//            startActivity(Intent(this,RegisterComplaint::class.java))
//        }
//
//        menu.setOnClickListener {
//            startActivity(Intent(this,ViewMenu::class.java))
//        }