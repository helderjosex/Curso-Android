package br.com.helderjose.lectures;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.helderjose.lectures.activities.ConferenciaActivity;
import br.com.helderjose.lectures.adapters.ListConferenciaAdapter;
import br.com.helderjose.lectures.models.Conferencia;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Conferências");

        listView = (ListView) findViewById(R.id.listViewConferencias);
        final ArrayList<Conferencia> conferencias = new ArrayList<>();

        Conferencia c1 = new Conferencia();
        c1.setId(1L);
        c1.setNome("Startup Weekend Maceió");
        c1.setLocal("Maceió");
        Conferencia c2 = new Conferencia();
        c2.setId(2L);
        c2.setNome("Startup Weekend Arapiraca");
        c2.setLocal("Arapiraca/AL");
        conferencias.add(c1);
        conferencias.add(c2);

        final ListConferenciaAdapter adapter = ListConferenciaAdapter.getInstance(this, conferencias);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Conferencia conferencia = (Conferencia) adapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, ConferenciaActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("conferencia", conferencia);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }
}
