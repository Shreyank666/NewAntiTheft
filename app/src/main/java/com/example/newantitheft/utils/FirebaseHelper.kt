package com.example.newantitheft.utils

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseHelper {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance("https://antitheftapp-fab83-default-rtdb.asia-southeast1.firebasedatabase.app")
    val locationRef: DatabaseReference = database.getReference("locations")
    val photosRef: DatabaseReference = database.getReference("photos")
}
