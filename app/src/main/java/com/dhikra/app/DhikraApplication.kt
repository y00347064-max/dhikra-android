package com.dhikra.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.dhikra.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DhikraApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        // Initialize Koin
        startKoin {
            androidContext(this@DhikraApplication)
            modules(appModule)
        }
        
        // Create notification channels
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NotificationManager::class.java)
            
            // Prayer Times Channel
            val prayerChannel = NotificationChannel(
                PRAYER_CHANNEL_ID,
                "Prayer Times",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Prayer time notifications"
            }
            
            // Adhan Channel
            val adhanChannel = NotificationChannel(
                ADHAN_CHANNEL_ID,
                "Adhan",
                NotificationManager.IMPORTANCE_MAX
            ).apply {
                description = "Adhan notifications"
            }
            
            // Daily Challenge Channel
            val challengeChannel = NotificationChannel(
                CHALLENGE_CHANNEL_ID,
                "Daily Challenge",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Daily challenge notifications"
            }
            
            notificationManager?.createNotificationChannel(prayerChannel)
            notificationManager?.createNotificationChannel(adhanChannel)
            notificationManager?.createNotificationChannel(challengeChannel)
        }
    }

    companion object {
        const val PRAYER_CHANNEL_ID = "prayer_channel"
        const val ADHAN_CHANNEL_ID = "adhan_channel"
        const val CHALLENGE_CHANNEL_ID = "challenge_channel"
    }
}
