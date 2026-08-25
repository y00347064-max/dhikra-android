package com.dhikra.app.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.dhikra.app.DhikraApplication
import com.dhikra.app.R

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (context == null) return

        val prayerName = intent?.getStringExtra("prayer_name") ?: "الصلاة"

        val notification = NotificationCompat.Builder(
            context,
            DhikraApplication.PRAYER_CHANNEL_ID
        )
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("موعد الصلاة")
            .setContentText("حان موعد صلاة $prayerName")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        NotificationManagerCompat.from(context).notify(prayerName.hashCode(), notification)
    }
}
