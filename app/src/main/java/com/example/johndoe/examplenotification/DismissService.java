package com.example.johndoe.examplenotification;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by johndoe on 10/3/17.
 */

public class DismissService extends IntentService{
    public DismissService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int channelId = intent.getIntExtra("ID", 0);
        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(channelId);

    }
}
