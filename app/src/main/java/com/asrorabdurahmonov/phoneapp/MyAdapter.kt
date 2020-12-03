package com.asrorabdurahmonov.phoneapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item.view.*

// I used this adapter for ListViews and GridView in this project.

class MyAdapter(private val list: ArrayList<String>, private val listItemId: Int) : BaseAdapter() {
    override fun getCount(): Int = list.size
    override fun getItem(position: Int): Any = list[position]
    override fun getItemId(position: Int): Long = position.toLong()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView = convertView ?: LayoutInflater.from(parent?.context)
            .inflate(listItemId, parent, false)
        itemView.item_txt.text = list[position]
        return itemView
    }
}