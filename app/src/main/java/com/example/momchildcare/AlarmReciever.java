package com.example.momchildcare;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        int notificationId=intent.getIntExtra("notificationId",0);
        String message=intent.getStringExtra("todo");
        Intent mainIntent=new Intent(context,MainActivity.class);
        PendingIntent contentIntent=PendingIntent.getActivity(context,0,mainIntent,0);
        NotificationManager myNotificationManager=
                (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
        //prepare notification
        Notification.Builder builder=new Notification.Builder(context);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("it's time")
                .setContentText(message)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentIntent(contentIntent);
        //notify
        myNotificationManager.notify(notificationId,builder.build());
    }
}
