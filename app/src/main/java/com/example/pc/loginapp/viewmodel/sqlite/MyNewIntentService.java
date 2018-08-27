package com.example.pc.loginapp.viewmodel.sqlite;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationManagerCompat;

import com.example.pc.loginapp.R;
import com.example.pc.loginapp.view.ui.Note_Activity;

/**
 * Created by Pc on 07-08-2018.
 */

public class MyNewIntentService extends IntentService {
    private static final int NOTIFICATION_ID = 3;

    public MyNewIntentService() {
        super("MyNewIntentService");
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Notes");
        builder.setContentText("Add your Important Tasks Here");
        builder.setSmallIcon(R.drawable.outline_pets_black_18dp);

        Intent notifyIntent = new Intent(this, Note_Activity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 2, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notificationCompat = builder.build();
        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(this);
        managerCompat.notify(NOTIFICATION_ID, notificationCompat);
    }
}





