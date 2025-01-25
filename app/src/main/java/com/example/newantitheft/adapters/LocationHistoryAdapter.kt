package com.example.newantitheft.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newantitheft.R
import com.example.newantitheft.models.LocationData
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LocationHistoryAdapter(private val locationList: List<LocationData>) :
    RecyclerView.Adapter<LocationHistoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val latitudeTextView: TextView = itemView.findViewById(R.id.latitudeTextView)
        val longitudeTextView: TextView = itemView.findViewById(R.id.longitudeTextView)
        val timestampTextView: TextView = itemView.findViewById(R.id.timestampTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_location_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locationList[position]
        holder.latitudeTextView.text = "Latitude: ${location.latitude}"
        holder.longitudeTextView.text = "Longitude: ${location.longitude}"
        holder.timestampTextView.text = "Time: ${formatTimestamp(location.timestamp)}"
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    private fun formatTimestamp(timestamp: Long): String {
        val date = Date(timestamp)
        val format = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
        return format.format(date)
    }
}