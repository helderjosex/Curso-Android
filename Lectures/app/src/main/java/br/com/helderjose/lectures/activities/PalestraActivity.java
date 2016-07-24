package br.com.helderjose.lectures.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.helderjose.lectures.R;
import br.com.helderjose.lectures.adapters.ListPalestraAdapter;
import br.com.helderjose.lectures.models.Conferencia;
import br.com.helderjose.lectures.models.Palestra;

public class PalestraActivity extends AppCompatActivity {

    private ListView listaPalestras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palestra);

        setTitle("Programação");
        listaPalestras = (ListView) findViewById(R.id.listaPalestras);
        ArrayList<Palestra> palestras = (ArrayList<Palestra>) getIntent().getSerializableExtra("palestras");
        ListPalestraAdapter adapter = ListPalestraAdapter.getInstance(this, palestras);
        listaPalestras.setAdapter(adapter);

    }
}
