package br.com.cd.threads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.cd.threads.R;
import br.com.cd.threads.model.Aluno;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class AlunosAdapter extends BaseAdapter {

    private Context context;
    private List<Aluno> alunos;


    public AlunosAdapter (Context context, List<Aluno> alunos){

        this.alunos = alunos;
        this.context = context;

    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Infla o layout de um item da lista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.alunos_list_item, null);
        }

        // Recupera aluno
        Aluno aluno = alunos.get(position);

        // Pega view no layout xml
        TextView nomeAluno = (TextView) convertView.findViewById(R.id.nomeAluno);
        TextView matricula = (TextView) convertView.findViewById(R.id.matricula);
        TextView email = (TextView) convertView.findViewById(R.id.email);

        // Coloca valores no layout
        nomeAluno.setText(aluno.getNome());
        matricula.setText(aluno.getMatricula());
        email.setText(aluno.getEmail());

        return convertView;
    }

    public void setAlunos(List<Aluno> listaAlunos){

        alunos = listaAlunos;


    }
}
