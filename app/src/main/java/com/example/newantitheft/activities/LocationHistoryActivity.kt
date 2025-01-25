package com.example.newantitheft.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newantitheft.R
import com.example.newantitheft.adapters.LocationHistoryAdapter
import com.example.newantitheft.models.LocationHistory

class LocationHistoryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var locationHistoryAdapter: LocationHistoryAdapter
    private var locationList: List<LocationHistory> = listOf() // Example data, you should fetch real data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_history)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerViewLocationHistory)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize and set the adapter
        locationHistoryAdapter = LocationHistoryAdapter(locationList)
        recyclerView.adapter = locationHistoryAdapter
    }
}
