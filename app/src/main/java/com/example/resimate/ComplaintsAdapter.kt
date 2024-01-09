package com.example.resimate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ComplaintsAdapter(private val compList : ArrayList<StudentComplaints>) : RecyclerView.Adapter<ComplaintsAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView =LayoutInflater.from(parent.context).inflate(R.layout.list_complaints, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currRoom=compList[position].Room
        val currProb=compList[position].Prob
        val currDesc=compList[position].Desc

        holder.room.text=currRoom
        holder.prob.text=currProb
        holder.desc.text=currDesc
    }

    override fun getItemCount(): Int {
        return compList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val room : TextView = itemView.findViewById(R.id.room_No)
        val prob : TextView = itemView.findViewById(R.id.prob)
        val desc : TextView = itemView.findViewById(R.id.desc)
    }
}