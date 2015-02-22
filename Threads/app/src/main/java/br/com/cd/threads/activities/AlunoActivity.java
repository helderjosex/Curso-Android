package br.com.cd.threads.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.threads.R;
import br.com.cd.threads.adapters.AlunosAdapter;
import br.com.cd.threads.model.Aluno;
import br.com.cd.threads.tasks.BuscarAlunosDBTask;
import br.com.cd.threads.tasks.BuscarAlunosTask;

public class AlunoActivity extends ActionBarActivity {

    private ListView listView;
    private AlunosAdapter adapter;
    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno);

        // COLOCAR O CARREGAMENTO DOS DADOS EM THREADS SEPARADA PARA PUXAR DO SERVIDOR
        listView = (ListView) findViewById(R.id.listaAlunos);
        //new BuscarAlunosTask(AlunoActivity.this).execute(listView);
        new BuscarAlunosDBTask(AlunoActivity.this).execute(listView);

    }

    public void atualizarLista (View v) {
        //new BuscarAlunosTask(AlunoActivity.this).execute(listView);
        new BuscarAlunosDBTask(AlunoActivity.this).execute(listView);
    }

}
