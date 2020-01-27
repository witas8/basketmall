package com.example.basketmall;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        createNotification(context, "It's shopping time!", "Check your basket");
    }

    public void createNotification(Context context, String msg, String msgText){
        PendingIntent notifyIntent = PendingIntent.getActivity( context, 0, new Intent( context, BasketHandler.class), 0 );

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder( context, "notifyId")
                .setSmallIcon( R.drawable.shoppingbasket_ic )
                .setContentTitle( msg )
                .setAutoCancel( true )
                .setContentIntent( notifyIntent )
                .setDefaults( NotificationCompat.DEFAULT_SOUND )
                .setContentText( msgText );


        NotificationManager notificationManager = (NotificationManager) context.getSystemService( Context.NOTIFICATION_SERVICE );
        notificationManager.notify(200, mBuilder.build());
    }
}

