package com.example.newantitheft.services

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.example.newantitheft.R

class LocationService {

    fun getLocationIcon(context: Context): Drawable? {
        return ContextCompat.getDrawable(context, R.drawable.location_icon) // Ensure this resource exists in your drawable folder
    }
}
