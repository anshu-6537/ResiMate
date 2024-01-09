package com.example.resimate

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment



//class Home : Fragment() {
//
//
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
//
////        binding = FragmentHomeBinding.inflate(inflater, container, false)
////        binding.student.setOnClickListener {
////            val intent = Intent(this@Home.requireContext(), StudWelcomePg::class.java)
////            startActivity(intent)
////        }
////        binding.viewRoom.text="hello"
////        binding.viewRoom.setOnClickListener{
////            Toast.makeText(activity,"hello",Toast.LENGTH_SHORT).show()
////        }
////        return binding.root
//
//        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
//
//        val btn: Button = view.findViewById<View>(R.id.button) as Button
//        btn.setOnClickListener {
//            Log.d("hh", "sendFreeTextButton clicked")
//            val intent = Intent(activity, StudWelcomePg::class.java)
//            this@Home.startActivity(intent)
//        }
//
//        return view
//    }
//
//
//    }