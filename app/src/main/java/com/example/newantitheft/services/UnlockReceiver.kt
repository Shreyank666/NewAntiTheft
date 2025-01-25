package com.example.newantitheft.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.core.content.ContextCompat

class UnlockReceiver : BroadcastReceiver() {
    private var failedAttempts = 0

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_USER_PRESENT) {
            failedAttempts = 0
        } else if (intent.action == Intent.ACTION_SCREEN_OFF) {
            failedAttempts++
            if (failedAttempts >= 3) {
                val captureIntent = Intent(context, CapturePhotoService::class.java)
                ContextCompat.startForegroundService(context, captureIntent)
            }
        }
    }
}
