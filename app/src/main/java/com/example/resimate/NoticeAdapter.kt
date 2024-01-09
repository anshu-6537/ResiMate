package com.example.resimate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticeAdapter(private val noticeList:ArrayList<CollegeNotice>) :  RecyclerView.Adapter<NoticeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_notice_item, parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val head=noticeList[position].heading
        val desc=noticeList[position].desc

        holder.heading.text=head
        holder.desc.text=desc
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val heading : TextView = itemView.findViewById(R.id.noticeTitle)
        val desc : TextView = itemView.findViewById(R.id.noticeDesc)

    }
}
