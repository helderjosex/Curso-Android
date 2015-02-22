package br.com.cd.alarms;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by fernandooliveira on 21/02/15.
 */
public class CreateNotificationBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);

        Calendar horaDeExibicao = Calendar.getInstance();
        horaDeExibicao.add(Calendar.MINUTE, 1);
        Log.d("data", horaDeExibicao.getTime().toString());


        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle("Conhecimento Digital")
                .setContentText("Conhecimento Digital é Mara!")
                .setSmallIcon(R.drawable.abc_tab_indicator_material)
                .setWhen(horaDeExibicao.getTimeInMillis())
                .setColor(Color.CYAN)
                .setTicker("Ticker")
                .addAction(R.drawable.abc_ic_ab_back_mtrl_am_alpha, "Abrir APP", pendingIntent)
                .setContentIntent(pendingIntent);

        Notification notification = builder.getNotification();
        notification.tickerText = "teste";
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}