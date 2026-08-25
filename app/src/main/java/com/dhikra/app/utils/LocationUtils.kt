package com.dhikra.app.utils

import android.content.Context
import android.location.LocationManager

object LocationUtils {
    fun isLocationEnabled(context: Context): Boolean {
        val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isLocationEnabled
    }

    fun calculateQiblaDirection(latitude: Double, longitude: Double): Double {
        // Kaaba coordinates
        val kaabaLat = 21.4225
        val kaabaLon = 39.8262

        val latRad = Math.toRadians(latitude)
        val lonRad = Math.toRadians(longitude)
        val kaabaLatRad = Math.toRadians(kaabaLat)
        val kaabaLonRad = Math.toRadians(kaabaLon)

        val dLon = kaabaLonRad - lonRad
        val y = Math.sin(dLon) * Math.cos(kaabaLatRad)
        val x = Math.cos(latRad) * Math.sin(kaabaLatRad) - Math.sin(latRad) * Math.cos(kaabaLatRad) * Math.cos(dLon)
        val bearing = Math.toDegrees(Math.atan2(y, x))
        return (bearing + 360) % 360
    }
}
