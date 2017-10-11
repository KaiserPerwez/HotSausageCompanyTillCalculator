package com.hotsausagecompany.app.hotsausagecompanytillcalculator.receivers;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.hotsausagecompany.app.hotsausagecompanytillcalculator.AlarmReceiver;

import java.util.Calendar;


public class DeviceBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "I'm running boot.Register alarm", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Set the alarm here.
            AlarmManager alarmMgr;
            Intent alarmIntent;
            PendingIntent alarmPendingIntent;

        /* Retrieve a PendingIntent that will perform a broadcast */
            alarmMgr = (AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
            alarmIntent = new Intent(context, AlarmReceiver.class);
            alarmPendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);

            // Set the alarm to start at 8:30 a.m.
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            calendar.set(Calendar.HOUR_OF_DAY, 18);
            calendar.set(Calendar.MINUTE, 0);

            // setRepeating() lets you specify a precise custom interval--in this case,
            // 10 minutes.
            alarmMgr.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                    1000 * 60 * 10, alarmPendingIntent);

            Toast.makeText(context, "Alarm has been set from BOOT!", Toast.LENGTH_SHORT).show();
        }


    }
}