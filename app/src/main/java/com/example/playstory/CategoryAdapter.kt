package com.example.playstory

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(val items: ArrayList<CategoryModel>): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_layout, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.name.text = items[position].name

        if (items[position].active) {
            holder.name.setTextColor(Color.parseColor("#25447f"))
            holder.line.setBackgroundColor(Color.parseColor("#25447f"))
        } else {
            holder.name.setTextColor(Color.parseColor("#000000"))
            holder.line.setBackgroundColor(Color.TRANSPARENT)
        }

        holder.name.setOnClickListener{
            items.forEach{ it.active = false }
            items[position].active = true
            notifyDataSetChanged()
        }
    }
}

class CategoryViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
    val name: TextView
    val line: View

    init {
        name = itemView.findViewById(R.id.categoryName)
        line = itemView.findViewById(R.id.categoryLine)
    }
}