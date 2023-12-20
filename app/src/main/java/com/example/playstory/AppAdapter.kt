package com.example.playstory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AppAdapter(val items: ArrayList<AppModel>): RecyclerView.Adapter<AppViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.app_layout, parent, false)
        return AppViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {
        holder.appImg.setImageResource(items[position].img)
        holder.appName.text = items[position].name
        holder.appRate.text = items[position].rate.toString()
    }
}

class AppViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val appImg: ImageView
    val appName: TextView
    val appRate: TextView

    init {
        appImg = itemView.findViewById(R.id.appImg)
        appName = itemView.findViewById(R.id.appName)
        appRate = itemView.findViewById(R.id.appRate)
    }
}