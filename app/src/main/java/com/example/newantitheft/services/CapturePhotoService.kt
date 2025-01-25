package com.example.newantitheft.services

import android.content.Context
import android.hardware.camera2.CameraCharacteristics
import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class CapturePhotoService : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize camera service
    }

    fun capturePhoto(context: Context) {
        val cameraManager = context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraId = cameraManager.cameraIdList[0] // Get first camera

        val characteristics = cameraManager.getCameraCharacteristics(cameraId)
        val lensFacing = characteristics.get(CameraCharacteristics.LENS_FACING)

        if (lensFacing != null && lensFacing == CameraCharacteristics.LENS_FACING_FRONT) {
            // Front camera
        }
    }
}
