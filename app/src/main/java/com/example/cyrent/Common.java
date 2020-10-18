package com.example.cyrent;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.widget.TextView;

import androidx.core.app.NotificationCompat;

import com.example.cyrent.Model.DriverInfoModel;

import java.util.Calendar;

public class Common {
    public static final String DRIVER_INFO_REFERENCE="DriverInfo";
    public static final String DRIVER_LOCATION_REFERENCES ="LenderLocation" ;
    public static final String TOKEN_REFERENCE = "Token" ;
    public static final String NOTI_TITLE = "title";
    public static final String NOTI_CONTENT ="body" ;
    public static DriverInfoModel currentUser;


      public static CharSequence buildWelcomeMessage() {   // string not working so CharSequence
        if(Common.currentUser != null)
        {
            return new StringBuilder("Welcome ")
                    .append(Common.currentUser.getFirstName())
                    .append(" ")
                    .append(Common.currentUser.getLastName());
        }
        else return "";
    }

    public static void setWelcomeMessage(TextView txt_welcome) {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if(hour >= 1 && hour <= 12)
            txt_welcome.setText(new StringBuilder("Good Morning."));
        else if(hour >= 13 && hour <= 17)
            txt_welcome.setText(new StringBuilder("Good Afternoon."));
        else txt_welcome.setText(new StringBuilder("Good Evening."));
    }

   public static void showNotification(Context context, int id, String title, String body, Intent intent) {
        PendingIntent pendingIntent=null;
        if(intent!=null)
            pendingIntent=PendingIntent.getActivity(context,id,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        String NOTIFICATION_CHANNEL_ID="CyRent";
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel=new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "CyRent",NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("CyRent");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0,1000,500,1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);

        }
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,NOTIFICATION_CHANNEL_ID);
        builder.setContentText(title)
                .setContentText(body)
                .setAutoCancel(false)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.ic_baseline_electric_bike_24)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.drawable.ic_baseline_electric_bike_24));
        if(pendingIntent !=null)
        {
            builder.setContentIntent(pendingIntent);
        }
        Notification notification= builder.build();
        notificationManager.notify(id,notification);


    }
}
