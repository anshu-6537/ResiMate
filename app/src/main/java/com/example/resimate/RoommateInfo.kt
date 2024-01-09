package com.example.resimate

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextClock
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.*
import java.util.stream.IntStream.range
import kotlin.collections.ArrayList


class RoommateInfo : AppCompatActivity() {

    private lateinit var newRecyclerview :RecyclerView
//    private lateinit var mydataList : ArrayList<StudentDetail>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_roommate_info)

        val myDataList:ArrayList<StudentDetail> = intent.getSerializableExtra("myList") as ArrayList<StudentDetail>
        val rNo=intent.getStringExtra("Room")
        Log.d("hllo", myDataList.toString())
        Toast.makeText(this, myDataList.toString(), Toast.LENGTH_SHORT).show()

        val roomNo :TextView=findViewById(R.id.room_no)
        val remainingBed:TextView=findViewById(R.id.remaining_bed)

        roomNo.text=rNo

        remainingBed.text="Beds Remaining : ${4-myDataList.size}"

        newRecyclerview=findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager =LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newRecyclerview.adapter=MyAdapter(myDataList)





//        val stud1=findViewById<ConstraintLayout>(R.id.stud1)
//        val stud2=findViewById<ConstraintLayout>(R.id.stud2)
//        val stud3=findViewById<ConstraintLayout>(R.id.stud3)
//        val stud4=findViewById<ConstraintLayout>(R.id.stud4)
//
//
//
//        val name1=findViewById<TextView>(R.id.name1)
//        val name2=findViewById<TextView>(R.id.name2)
//        val name3=findViewById<TextView>(R.id.name3)
//        val name4=findViewById<TextView>(R.id.name4)
//
//        val age1=findViewById<TextView>(R.id.age1)
//        val age2=findViewById<TextView>(R.id.age2)
//        val age3=findViewById<TextView>(R.id.age3)
//        val age4=findViewById<TextView>(R.id.age4)
//
//        val room1=findViewById<TextView>(R.id.room1)
//        val room2=findViewById<TextView>(R.id.room2)
//        val room3=findViewById<TextView>(R.id.room3)
//        val room4=findViewById<TextView>(R.id.room4)
//
//        val branch1=findViewById<TextView>(R.id.branch1)
//        val branch2=findViewById<TextView>(R.id.branch2)
//        val branch3=findViewById<TextView>(R.id.branch3)
//        val branch4=findViewById<TextView>(R.id.branch4)
//
//        val leftBed=findViewById<TextView>(R.id.remaining_bed)
//
//        if(myDataList.size==4)
//        {
//            leftBed.visibility= View.VISIBLE
//            leftBed.text="No Beds are left in this Room."
//
//            for(i in range(0,myDataList.size))
//            {
//                name1.text = myDataList[i].Name
//                age1.text=(myDataList[i].Age)
//                room1.text = myDataList[i].Room
//                branch1.text = myDataList[i].Branch
//            }
//        }
//        else if(myDataList.size==3)
//        {
//            leftBed.visibility=View.VISIBLE
//            leftBed.text="Remaining Beds : 1"
//
//            stud4.visibility=View.INVISIBLE
////            stud3.visibility=View.INVISIBLE
////            stud2.visibility=View.INVISIBLE
//
//
//            for(i in range(0,myDataList.size))
//            {
//                name1.text = myDataList[i].Name
//                age1.text=(myDataList[i].Age)
//                room1.text = myDataList[i].Room
//                branch1.text = myDataList[i].Branch
//            }
//        }
//        else if(myDataList.size==2)
//        {
//            leftBed.visibility=View.VISIBLE
//            leftBed.text="Remaining Beds : 2"
//
//            stud4.visibility=View.INVISIBLE
//            stud3.visibility=View.INVISIBLE
////            stud2.visibility=View.INVISIBLE
//
//
//            for(i in range(0,myDataList.size))
//            {
//                name1.text = myDataList[i].Name
//                age1.text=(myDataList[i].Age)
//                room1.text = myDataList[i].Room
//                branch1.text = myDataList[i].Branch
//            }
//        }
//        else if(myDataList.size==1)
//        {
//            //SET VISIBILITY OF VIEWS
//            leftBed.visibility=View.VISIBLE
//            leftBed.text="Remaining Beds : 3"
//
//            stud4.visibility=View.INVISIBLE
//            stud3.visibility=View.INVISIBLE
//            stud2.visibility=View.INVISIBLE
//
//
//            for(i in range(0,myDataList.size))
//            {
//                name1.text = myDataList[i].Name
//                age1.text=(myDataList[i].Age)
//                room1.text = myDataList[i].Room
//                branch1.text = myDataList[i].Branch
//            }
//        }
//        else
//        {
//            leftBed.visibility=View.VISIBLE
//            leftBed.text="Remaining Beds : 4"
//
//            stud4.visibility=View.INVISIBLE
//            stud3.visibility=View.INVISIBLE
//            stud2.visibility=View.INVISIBLE
//            stud1.visibility=View.INVISIBLE
//        }

    }


}