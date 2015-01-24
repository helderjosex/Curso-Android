package br.com.conhecimentodigital.academico;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listViewCursos);

        List<Curso> cursos = new ArrayList<>();
        Curso c1 = new Curso();
        c1.setNome("Java Desktop");
        c1.setStatus("Concluído");

        Curso c2 = new Curso();
        c2.setNome("Desenvolvedor Android");
        c2.setStatus("Em Andamento");

        cursos.add(c1);
        cursos.add(c2);

        ListCursoAdapter adapter = ListCursoAdapter.getInstance(this,cursos);
        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
