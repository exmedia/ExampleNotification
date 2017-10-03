package com.example.johndoe.examplenotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private static final String CHANNEL_ID_EXTRA = "CHANNEL_ID";
    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Show notification
        final String ChannelId = "DEFAULT_CHANNEL";
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel channel = new NotificationChannel(ChannelId, "Default Channel", NotificationManager.IMPORTANCE_DEFAULT);
        }
        NotificationCompat.Builder builder;
            builder = new NotificationCompat.Builder(getApplicationContext());
        builder.setContentText("Jack Calling")
                .setAutoCancel(true)
                .setSmallIcon(R.drawable.notif)
                .setChannel(ChannelId);
        Intent intent = new Intent(getApplicationContext(),DismissService.class);
        intent.putExtra("ID",NOTIFICATION_ID);
        PendingIntent pendingIntent = PendingIntent.getService(getApplicationContext(),REQUEST_CODE,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action = new NotificationCompat.Action(R.drawable.check,getString(R.string.mark_read), pendingIntent);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID,builder.build());
    }
}
