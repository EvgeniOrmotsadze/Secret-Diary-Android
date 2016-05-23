package com.example.evgo.secretdiary.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import com.example.evgo.secretdiary.MainActivity;
import com.example.evgo.secretdiary.R;

import java.util.Calendar;

/**
 * Created by evgo on 6/12/2015.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onReceive(Context context, Intent intent) {

       Notification.Builder mBuilder =
                    new Notification.Builder(context)
                            .setSmallIcon(R.mipmap.launcher)
                            .setContentTitle("Remainder for your diary")
                            .setContentText("go to in your diary");
            Intent resultIntent = new Intent(context, MainActivity.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(MainActivity.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, mBuilder.build());
    }
}
