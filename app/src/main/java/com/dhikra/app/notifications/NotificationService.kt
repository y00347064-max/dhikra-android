package com.dhikra.app.notifications

import android.app.Service
import android.content.Intent
import android.os.IBinder

class NotificationService : Service() {
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Handle notification service logic
        return START_STICKY
    }
}
