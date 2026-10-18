package com.shift.calendar.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val shiftType = intent.getStringExtra("SHIFT_TYPE") ?: "근무"
        
        val channelId = "shift_alarm_channel"
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "근무 알람",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "교대 근무 지정 시각 알람"
                enableVibration(true)
            }
            notificationManager.createNotificationChannel(channel)
        }

        val alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            ?: RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_lock_idle_alarm)
            .setContentTitle("근무 알람 - $shiftType")
            .setContentText("설정하신 근무 알람 시간입니다. 확인해 주세요!")
            .setPriority(NotificationCompat.PRIORITY_MAX)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setSound(alarmUri)

        notificationManager.notify(System.currentTimeMillis().toInt(), builder.build())
    }
}
