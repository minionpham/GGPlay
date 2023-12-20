package com.example.playstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = arrayListOf<CategoryModel>(
            CategoryModel("For you", true),
            CategoryModel("Top chats"),
            CategoryModel("Other devices"),
            CategoryModel("Kid"),
            CategoryModel("Pay fee")
        )

        val appsHeader = arrayListOf<AppModel>(
            AppModel(R.drawable.reddit, "Reddit", 4.1),
            AppModel(R.drawable.reuters, "Reuters News", 4.6),
            AppModel(R.drawable.newyork, "The New York Times", 4.6),
            AppModel(R.drawable.traveloka, "Traveloka: Hotels & Fights", 4.7),
        )

        val appsBooking = arrayListOf<AppModel>(
            AppModel(R.drawable.traveloka, "Traveloka: Hotels & Fights", 4.7),
            AppModel(R.drawable.triplt, "Triplt: Travel Planner", 4.6),
            AppModel(R.drawable.quata_airway, "Quata Airways", 4.7),
            AppModel(R.drawable.reddit, "Reddit", 4.1),
        )

        val appsPopular = arrayListOf<AppModel>(
            AppModel(R.drawable.quanda, "Quanda", 4.1),
            AppModel(R.drawable.booking, "Booking", 4.6),
            AppModel(R.drawable.amazon, "Amazon", 4.6),
            AppModel(R.drawable.reddit, "Reddit", 4.1),
        )

        val appCategories = arrayListOf<AppCategoryModel>(
            AppCategoryModel("", appsHeader),
            AppCategoryModel("Fight booking", appsBooking),
            AppCategoryModel("Popular apps", appsPopular),
            AppCategoryModel("New apps", appsHeader),
            AppCategoryModel("Fight booking", appsBooking),
            AppCategoryModel("Popular apps", appsPopular),

        )

        val categoryAdapter = CategoryAdapter(categories)
        val categoryView = findViewById<RecyclerView>(R.id.category)
        categoryView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        categoryView.adapter = categoryAdapter

        val contentAdapter = AppCategoryAdapter(appCategories)
        val contentView = findViewById<RecyclerView>(R.id.contentView)
        contentView.layoutManager = LinearLayoutManager(this)
        contentView.adapter = contentAdapter
    }
}