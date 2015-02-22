package br.com.cd.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    private TimePickerDialog timePickerDialog;
    private Calendar selectedDate = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void enviarSMS (View v){

        // Disparar 5 segundos depois
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,5);

        Intent intent = new Intent(this,SendSMSBroadcast.class);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT));

        Toast.makeText(this,"Alarme Disparado!",Toast.LENGTH_LONG).show();
    }

    public void showTimePicker(View v){
        if(timePickerDialog == null){
            // Hora atual
            Calendar cal = Calendar.getInstance();
            timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener(){

                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {


                        selectedDate.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        selectedDate.set(Calendar.MINUTE,minute);
                }
            },
             cal.get(Calendar.HOUR_OF_DAY),
             cal.get(Calendar.MINUTE),
             true);
        }

        timePickerDialog.show();
    }

    public void sendNotification (View v){

        Intent intent = new Intent(this,CreateNotificationBroadcast.class);

        PendingIntent resultPendingIntent  =  PendingIntent.getBroadcast(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, selectedDate.getTimeInMillis(), resultPendingIntent);

        Toast.makeText(this,"Alarme Disparado!",Toast.LENGTH_LONG).show();
    }

}
