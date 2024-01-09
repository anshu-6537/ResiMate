package com.example.resimate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val dataList : ArrayList<StudentDetail>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_stud_details,
        parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentName = dataList[position].Name
        val currentRoom = dataList[position].Room
        val currentBranch = dataList[position].Branch
        val currentAge = dataList[position].Age

        holder.name.text=currentName
        holder.branch.text=currentBranch
        holder.age.text=currentAge
        holder.room.text=currentRoom

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val name :TextView = itemView.findViewById(R.id.name)
        val branch :TextView = itemView.findViewById(R.id.branch)
        val age :TextView = itemView.findViewById(R.id.age)
        val room :TextView = itemView.findViewById(R.id.room)
    }
}