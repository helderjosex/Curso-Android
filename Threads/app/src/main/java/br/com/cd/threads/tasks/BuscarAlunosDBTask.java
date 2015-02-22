package br.com.cd.threads.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import br.com.cd.threads.adapters.AlunosAdapter;
import br.com.cd.threads.database.AlunoDAO;
import br.com.cd.threads.model.Aluno;
import br.com.cd.threads.rest_client.AlunoRestClient;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class BuscarAlunosDBTask extends AsyncTask<ListView,Void,List<Aluno>> {

    private ProgressDialog pDialog;
    private Activity activity;
    private ListView listView;
    private AlunosAdapter adapter;

    public BuscarAlunosDBTask(Activity activity) {

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

        AlunoDAO dao = new AlunoDAO(activity);
        List<Aluno> alunos = dao.findAll();

        return alunos;
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

    }
}
