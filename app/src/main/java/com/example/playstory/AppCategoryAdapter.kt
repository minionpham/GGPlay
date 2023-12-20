package com.example.playstory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AppCategoryAdapter(val items: ArrayList<AppCategoryModel>): RecyclerView.Adapter<AppCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppCategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_row_layout, parent, false)
        return AppCategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AppCategoryViewHolder, position: Int) {
        holder.title.text = items[position].title

        if (items[position].title == "") {
            holder.header.visibility = View.INVISIBLE
        } else {
            holder.header.visibility = View.VISIBLE
        }

        val appAdapter = AppAdapter(items[position].apps)
        holder.recyclerView.adapter = appAdapter
    }

}

class AppCategoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.appCategoryTitle)
    val header: LinearLayout = itemView.findViewById(R.id.appCategoryHeader)
    val recyclerView: RecyclerView = itemView.findViewById(R.id.appCategory)

    init {
        recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }
}