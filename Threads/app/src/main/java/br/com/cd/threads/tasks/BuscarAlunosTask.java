package br.com.cd.threads.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.threads.activities.AlunoActivity;
import br.com.cd.threads.adapters.AlunosAdapter;
import br.com.cd.threads.database.AlunoDAO;
import br.com.cd.threads.model.Aluno;
import br.com.cd.threads.rest_client.AlunoRestClient;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class BuscarAlunosTask extends AsyncTask<ListView,Void,List<Aluno>> {

    private ProgressDialog pDialog;
    private Activity activity;
    private ListView listView;
    private AlunosAdapter adapter;

    public BuscarAlunosTask(Activity activity) {

        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setTitle("Por Favor, aguarde!");
        pDialog.setMessage("Carregando Alunos ...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected List<Aluno> doInBackground(ListView... params) {

        listView = params[0];

        AlunoRestClient client = new AlunoRestClient();
        List<Aluno> alunos = client.findAll();

        if(alunos != null)
        {
            AlunoDAO dao = new AlunoDAO(activity);
            for (Aluno aluno : alunos) {
                dao.insert(aluno);
            }
        }


        return  alunos;
    }

    @Override
    protected void onPostExecute(List<Aluno> alunos) {
        super.onPostExecute(alunos);

        pDialog.dismiss();

        if(alunos != null){
            adapter = new AlunosAdapter(activity,alunos);
            listView.setAdapter(adapter);
        }else
        {
            adapter.setAlunos(alunos);
            adapter.notifyDataSetChanged();
        }

        // GRAVAR DADOS NO APARELHO CASO O USUARIOS FECHAR O APP
        SharedPreferences preferences = activity.getSharedPreferences("prefs", activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("quantidade_alunos", alunos.size());
        editor.commit();
    }
}
