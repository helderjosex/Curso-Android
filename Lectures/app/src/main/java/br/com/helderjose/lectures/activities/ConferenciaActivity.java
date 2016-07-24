package br.com.helderjose.lectures.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import br.com.helderjose.lectures.R;
import br.com.helderjose.lectures.models.Conferencia;
import br.com.helderjose.lectures.models.Hora;
import br.com.helderjose.lectures.models.Palestra;

public class ConferenciaActivity extends AppCompatActivity {

    private TextView txtNomeConferencia;
    private TextView txtLocalConferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conferencia);

        setTitle("Detalhes da Conferência");

        txtNomeConferencia = (TextView) findViewById(R.id.txtNomeConferencia);
        txtLocalConferencia = (TextView) findViewById(R.id.txtLocalConferencia);

        Intent intent = getIntent();
        Conferencia conferencia = (Conferencia) intent.getSerializableExtra("conferencia");

        txtNomeConferencia.setText(conferencia.getNome());
        txtLocalConferencia.setText(conferencia.getLocal());
    }

    public void listLectures(View view){
        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream;
        LinkedList<String> linhas = null;
        final ArrayList<Palestra> palestras = new ArrayList<>();
        try {
            inputStream = assetManager.open("proposals.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String row;
            linhas = new LinkedList<String>();
            while((row = bufferedReader.readLine())!=null){
                linhas.add(row);
            }
            ListIterator<String> it = linhas.listIterator(0);
            int minutos = 0;
            while (it.hasNext()) {
                int index = it.nextIndex();
                String nome = it.next();
                Palestra p = new Palestra();
                p.setId((long) index);

                Hora h = new Hora();
                h.setMinutos(minutos+60);
                h.addTime();
                String horaInicial = h.getHoraFormatada();

                p.setNome(nome);
                p.setHoraInicial(horaInicial);

                palestras.add(p);

                minutos = minutos+60;
            }

            Toast.makeText(this, "Carregando Programação...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PalestraActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("palestras", palestras);
            intent.putExtras(bundle);
            startActivity(intent);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
