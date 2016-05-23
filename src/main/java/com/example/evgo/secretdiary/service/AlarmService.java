package com.example.evgo.secretdiary.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.evgo.secretdiary.MainActivity;
import com.example.evgo.secretdiary.R;

/**
 * Created by evgo on 6/13/2015.
 */
public class AlarmService extends Service {

    private NotificationManager mManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("fuckme","ol");
        NotificationManager mNM = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.launcher, "Notify Alarm strart", System.currentTimeMillis());
        Intent myIntent = new Intent(this , MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, myIntent, 0);
        notification.setLatestEventInfo(this, "Notify label", "Notify text", contentIntent);
        mNM.notify(1,notification);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

    }
}
