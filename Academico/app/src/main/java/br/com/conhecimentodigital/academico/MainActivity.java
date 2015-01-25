package br.com.conhecimentodigital.academico;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView listView;
    private ListView listViewAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.listViewCursos);

        final ArrayList<Curso> cursos = new ArrayList<>();

        Curso c1 = new Curso();
        c1.setId(1L);
        c1.setNome("Java Desktop");
        c1.setStatus("CONCLUIDO");

        Curso c2 = new Curso();
        c2.setId(2L);
        c2.setNome("Desenvolvedor Android");
        c2.setStatus("EM ANDAMENTO");

        cursos.add(c1);
        cursos.add(c2);


        final ListCursoAdapter adapter = ListCursoAdapter.getInstance(this, cursos);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Curso curso = (Curso) adapter.getItem(position);

                Intent intent = new Intent(MainActivity.this, CursoActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("curso", curso);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
    }

    public void listarAlunos(View view){

        listViewAlunos = (ListView) findViewById(R.id.listViewAlunos);

        final ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno a1 = new Aluno();
        a1.setId(1L);
        a1.setNome("Helder");
        a1.setCpf("000.000.000-01");

        Aluno a2 = new Aluno();
        a2.setId(2L);
        a2.setNome("Aluno Fulano de tal");
        a2.setCpf("000.000.000-02");

        alunos.add(a1);
        alunos.add(a2);

        Toast.makeText(this, "Lista de Alunos!", Toast.LENGTH_LONG).show();


        final ListaAlunoAdapter adapter = ListaAlunoAdapter.getInstance(this,alunos);
        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Aluno aluno = (Aluno) adapter.getItem(position);

                Intent intent = new Intent(MainActivity.this, AlunoActivity.class);
                Bundle extras = new Bundle();
                extras.putSerializable("aluno", aluno);
                intent.putExtras(extras);
                startActivity(intent);
            }
        });
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
