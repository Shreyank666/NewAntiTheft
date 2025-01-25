package com.example.newantitheft.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newantitheft.R
import com.example.newantitheft.models.LocationHistory
import kotlinx.android.synthetic.main.item_location_history.view.*

class LocationHistoryAdapter(private val locationList: List<LocationHistory>) : RecyclerView.Adapter<LocationHistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_location_history, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = locationList[position]
        holder.latitudeTextView.text = location.latitude.toString()
        holder.longitudeTextView.text = location.longitude.toString()
        holder.timestampTextView.text = location.timestamp.toString()
    }

    override fun getItemCount(): Int {
        return locationList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val latitudeTextView = itemView.latitudeTextView
        val longitudeTextView = itemView.longitudeTextView
        val timestampTextView = itemView.timestampTextView
    }
}
