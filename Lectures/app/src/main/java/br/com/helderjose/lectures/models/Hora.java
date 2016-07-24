package br.com.helderjose.lectures.models;

import android.widget.Toast;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by helder on 21/07/16.
 */
public class Hora {
    private int minutos;
    private String horaFormatada;

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getHoraFormatada() {
        return horaFormatada;
    }

    public void setHoraFormatada(String horaFormatada) {
        this.horaFormatada = horaFormatada;
    }

    public void addTime() {
        GregorianCalendar gc = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time time = new Time(8,0,0);
        gc.setTimeInMillis(time.getTime());
        gc.add(Calendar.MINUTE,this.getMinutos());
        this.setHoraFormatada(sdf.format(gc.getTime()));
    }
}
