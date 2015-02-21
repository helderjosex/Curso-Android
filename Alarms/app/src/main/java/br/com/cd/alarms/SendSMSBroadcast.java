package br.com.cd.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

/**
 * Created by cd-101 on 21/02/2015.
 */
public class SendSMSBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String telefone = "8288618857";
        String mensagem = "Android é MARA!";

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(telefone,null,mensagem,null,null);

        Toast.makeText(context,"SMS enviado!", Toast.LENGTH_LONG).show();
    }
}
