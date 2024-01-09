package com.example.resimate

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(context: Context, courseModelArrayList: ArrayList<ItemModel>) :
    ArrayAdapter<ItemModel>(context, 0, courseModelArrayList as List<ItemModel?>) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var listitemView = convertView
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(context).inflate(R.layout.item_grid, parent, false)
        }

        val courseModel: ItemModel? = getItem(position)
        val courseTV = listitemView!!.findViewById<TextView>(R.id.studentText)
        val courseIV = listitemView.findViewById<ImageView>(R.id.student)

        if (courseModel != null) {
            courseTV.text = courseModel.getCourse_name()
        }
        if (courseModel != null) {
            courseIV.setImageResource(courseModel.getImgid())
        }
        return listitemView
    }
}