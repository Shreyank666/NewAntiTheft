package com.example.newantitheft.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.example.newantitheft.services.CapturePhotoService

class UnlockReceiver : BroadcastReceiver() {
    private var failedAttempts = 0
    private val handler = Handler(Looper.getMainLooper())
    private val resetFailedAttempts = Runnable { failedAttempts = 0 }

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_USER_PRESENT) {
            // User successfully unlocked the device
            failedAttempts = 0
            handler.removeCallbacks(resetFailedAttempts)
        } else if (intent.action == Intent.ACTION_SCREEN_OFF) {
            // Screen turned off, indicating a failed unlock attempt
            failedAttempts++
            handler.removeCallbacks(resetFailedAttempts)
            handler.postDelayed(resetFailedAttempts, 30000) // Reset after 30 seconds

            if (failedAttempts >= 3) {
                // Trigger photo capture
                val captureIntent = Intent(context, CapturePhotoService::class.java)
                context.startService(captureIntent)
                failedAttempts = 0 // Reset after capturing photo
            }
        }
    }
}
