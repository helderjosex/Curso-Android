package br.com.conhecimentodigital.notificacoes;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View v) {
        Intent intent = new Intent(this, NotificacaoActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Calendar horaDeExibicao = Calendar.getInstance();
        horaDeExibicao.add(Calendar.MINUTE, 1);
        Log.d("data", horaDeExibicao.getTime().toString());
        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(),
                R.drawable.kakaroto);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("Conhecimento Digital")
                .setContentText("Conhecimento Digital é Mara!")
                .setSmallIcon(R.drawable.ic_launcher)
                .setWhen(horaDeExibicao.getTimeInMillis())
                .setColor(Color.CYAN)
                .setLargeIcon(largeIcon)
                .setTicker("Ticker")
                .addAction(R.drawable.ic_launcher, "Abrir APP", pendingIntent)
                .setContentIntent(pendingIntent);

        Notification notification = builder.getNotification();
        notification.tickerText = "teste";
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);

    }


}
