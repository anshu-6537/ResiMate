package com.example.resimate

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import java.io.Serializable
import java.util.*


class RoomPreview : AppCompatActivity() {

    lateinit var read: Button
    var db: FirebaseFirestore? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room_preview)

        var floor = ""
        var room = ""

        val arrFloor = arrayOf("G", "F", "S", "T")
        val spinnerFloor = findViewById<Spinner>(R.id.floorSpinner)


        spinnerFloor.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                floor = arrFloor[position]

            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }


        findViewById<ImageButton>(R.id.washroom).setOnClickListener {
            Toast.makeText(this, "You have selected washroom area", Toast.LENGTH_SHORT).show()
        }
        findViewById<ImageButton>(R.id.stair).setOnClickListener {
            Toast.makeText(this, "You have selected staircase", Toast.LENGTH_SHORT).show()
        }

        //ROOM NUMBER ::::
        val left_wing = findViewById<RadioButton>(R.id.left_wing)
        val right_wing = findViewById<RadioButton>(R.id.right_wing)

        val room1 = findViewById<ImageButton>(R.id.room1)
        val room2 = findViewById<ImageButton>(R.id.room2)
        val room3 = findViewById<ImageButton>(R.id.room3)
        val room4 = findViewById<ImageButton>(R.id.room4)
        val room5 = findViewById<ImageButton>(R.id.room5)
        val room6 = findViewById<ImageButton>(R.id.room6)
        val room7 = findViewById<ImageButton>(R.id.room7)
        val room8 = findViewById<ImageButton>(R.id.room8)
        val room9 = findViewById<ImageButton>(R.id.room9)
        val room10 = findViewById<ImageButton>(R.id.room10)


        if (left_wing.isChecked) {

            room1.setOnClickListener {
                room = "1"
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show()
            }

            room2.setOnClickListener {
                room = "2"
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show()
            }

            room3.setOnClickListener {
                room = "3"
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show()
            }

            room4.setOnClickListener {
                room = "4"
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show()
            }

            room5.setOnClickListener {
                room = "5"
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show()
            }

            room6.setOnClickListener {
                room = "6"
                Toast.makeText(this, "6", Toast.LENGTH_SHORT).show()
            }

            room7.setOnClickListener {
                room = "7"
                Toast.makeText(this, "7", Toast.LENGTH_SHORT).show()
            }

            room8.setOnClickListener {
                room = "8"
                Toast.makeText(this, "8", Toast.LENGTH_SHORT).show()
            }

            room9.setOnClickListener {
                room = "9"
                Toast.makeText(this, "9", Toast.LENGTH_SHORT).show()
            }

            room10.setOnClickListener {
                room = "10"
                Toast.makeText(this, "10", Toast.LENGTH_SHORT).show()
            }

        } else if (right_wing.isChecked) {
            room1.setOnClickListener {
                room = "11"
                Toast.makeText(this, "11", Toast.LENGTH_SHORT).show()
            }
            room2.setOnClickListener {
                room = "12"
                Toast.makeText(this, "12", Toast.LENGTH_SHORT).show()
            }
            room3.setOnClickListener {
                room = "13"
                Toast.makeText(this, "13", Toast.LENGTH_SHORT).show()
            }
            room4.setOnClickListener {
                room = "14"
                Toast.makeText(this, "14", Toast.LENGTH_SHORT).show()
            }
            room5.setOnClickListener {
                room = "15"
                Toast.makeText(this, "15", Toast.LENGTH_SHORT).show()
            }
            room6.setOnClickListener {
                room = "16"
                Toast.makeText(this, "16", Toast.LENGTH_SHORT).show()
            }
            room7.setOnClickListener {
                room = "17"
                Toast.makeText(this, "17", Toast.LENGTH_SHORT).show()
            }
            room8.setOnClickListener {
                room = "18"
                Toast.makeText(this, "18", Toast.LENGTH_SHORT).show()
            }
            room9.setOnClickListener {
                room = "19"
                Toast.makeText(this, "19", Toast.LENGTH_SHORT).show()
            }
            room10.setOnClickListener {
                room = "20"
                Toast.makeText(this, "20", Toast.LENGTH_SHORT).show()
            }
        }
//        val finalroom= floor+"-"+room

            val list = ArrayList<StudentDetail>()

            db = FirebaseFirestore.getInstance()
            read = findViewById(R.id.test)
            read.setOnClickListener {

                Toast.makeText(this, "$floor-$room", Toast.LENGTH_SHORT).show()

                db!!.collection("user")
                    .whereEqualTo("Room", "$floor-$room")
                    .get()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(this@RoomPreview, "Successful", Toast.LENGTH_LONG).show()
                            for (document in task.result) {

                                list.add(
                                    StudentDetail(
                                        document.get("Branch") as String,
                                        document.get("Room") as String,
                                        document.get("Age") as String,
                                        document.get("Name") as String
                                    )
                                )
                            }
                        } else {
                            Toast.makeText(this@RoomPreview, "Failed", Toast.LENGTH_LONG).show()
                        }
//                    Toast.makeText(this,list.toString(),Toast.LENGTH_SHORT).show()
//                    Log.d("lo", list[0].Name)

                        val intent = Intent(this, RoommateInfo::class.java)
                        intent.putExtra("myList", list as Serializable)
                        intent.putExtra("Room", "$floor-$room")
                        startActivity(intent)
                    }


            }
        }
    }

//    companion object {
//        const val TAG = "Read Data Activity"
//    }
