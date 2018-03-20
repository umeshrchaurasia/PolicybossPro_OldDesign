package com.datacomp.magicfinmart.utility;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.datacomp.magicfinmart.R;
import com.datacomp.magicfinmart.home.HomeActivity;
import com.datacomp.magicfinmart.splashscreen.SplashScreenActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

import magicfinmart.datacomp.com.finmartserviceapi.PrefManager;
import magicfinmart.datacomp.com.finmartserviceapi.Utility;
import magicfinmart.datacomp.com.finmartserviceapi.finmart.model.NotifyEntity;

/**
 * Created by IN-RB on 21-02-2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    public static final String CHANNEL_ID = "com.datacomp.magicfinmart.NotifyID";

    String type;
    String WebURL, WebTitle, messageId;
    NotifyEntity notifyEntity;
    PrefManager prefManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        sendNotification(remoteMessage, remoteMessage.getData());
    }

    private void sendNotification(RemoteMessage remoteMessage, Map<String, String> data) {

        notifyEntity = new NotifyEntity();
        prefManager = new PrefManager(getApplicationContext());
        int NOTIFICATION_ID = 0;

        NOTIFICATION_ID = (int) Math.round(Math.random() * 100);
        if (remoteMessage.getData().size() == 0) {
            Log.d(TAG, "Message Data Body Empty: ");
            return;
        }
        Log.d(TAG, remoteMessage.getData().get("notifyFlag"));
        Map<String, String> NotifyData = remoteMessage.getData();
        Intent intent;
        if (NotifyData.get("notifyFlag") == null) {
            return;
        } else {
            type = NotifyData.get("notifyFlag");

            if (NotifyData.get("web_url") == null) {
                WebURL = "";
                WebTitle = "";
            }

            if (NotifyData.get("message_id") == null) {
                messageId = "0";
            }
            if (NotifyData.get("message_id").toString().isEmpty()) {
                messageId = "0";
            }

            messageId = NotifyData.get("message_id");
            WebURL = NotifyData.get("web_url");
            WebTitle = NotifyData.get("web_title");

            notifyEntity.setNotifyFlag(type);
            notifyEntity.setMessage_id(messageId);
            notifyEntity.setWeb_url(WebURL);
            notifyEntity.setWeb_url(WebTitle);


            intent = new Intent(this, HomeActivity.class);
            intent.putExtra(Constants.PUSH_NOTIFY, notifyEntity);

        }


        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, (int) Math.round(Math.random() * 100), intent,
                PendingIntent.FLAG_CANCEL_CURRENT);


        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder notificationBuilder = null;

        notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);

        notificationBuilder
                .setSmallIcon(R.drawable.finmart_logo)
                .setContentTitle(NotifyData.get("title"))
                .setContentText(NotifyData.get("body"))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setTicker("Finmart")
                .setPriority(Notification.PRIORITY_HIGH)
                .setWhen(System.currentTimeMillis())

                .setStyle(new NotificationCompat.BigTextStyle().bigText(NotifyData.get("body")))
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NOTIFICATION_ID, notificationBuilder.build());

        setNotifyCounter();
    }

    private void setNotifyCounter() {
        int notifyCounter = prefManager.getNotificationCounter();
        prefManager.setNotificationCounter(notifyCounter + 1);

        Intent intent = new Intent(Utility.PUSH_BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);


    }
}
