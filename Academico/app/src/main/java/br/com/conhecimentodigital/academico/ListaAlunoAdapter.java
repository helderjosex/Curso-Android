package br.com.conhecimentodigital.academico;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by helderjose on 25/01/15.
 */
public class ListaAlunoAdapter extends BaseAdapter {

    private Activity activity;
    private List<Aluno> alunos;

    public static ListaAlunoAdapter getInstance(Activity activity, List<Aluno> alunos) {
        ListaAlunoAdapter adapter = new ListaAlunoAdapter();
        adapter.activity = activity;
        adapter.alunos = alunos;

        return adapter;

    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Object getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lista_alunos_item, null);
        }

        Aluno aluno = (Aluno) getItem(position);

        TextView txtNomeAluno = (TextView) convertView.findViewById(R.id.txtNomeAluno);
        TextView txtCpfAluno = (TextView) convertView.findViewById(R.id.txtCpfAluno);

        txtNomeAluno.setText(aluno.getNome());
        txtCpfAluno.setText(aluno.getCpf());

        return convertView;
    }
}
