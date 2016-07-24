package br.com.helderjose.lectures.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.helderjose.lectures.R;
import br.com.helderjose.lectures.models.Conferencia;

/**
 * Created by helder on 20/07/16.
 */
public class ListConferenciaAdapter extends BaseAdapter {

    private Activity activity;
    private List<Conferencia> conferencias;

    public static ListConferenciaAdapter getInstance(Activity activity, List<Conferencia> conferencias) {
        ListConferenciaAdapter adapter = new ListConferenciaAdapter();
        adapter.activity = activity;
        adapter.conferencias = conferencias;
        return adapter;
    }

    private ListConferenciaAdapter() {}

    @Override
    public int getCount() {
        return conferencias.size();
    }

    @Override
    public Object getItem(int position) {
        return conferencias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return conferencias.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.conferencias_list_item, null);
        }
        Conferencia conferencia = (Conferencia) getItem(position);
        TextView txtNomeConferencia = (TextView) convertView.findViewById(R.id.txtNomeConferencia);
        TextView txtLocal = (TextView) convertView.findViewById(R.id.txtLocalConferencia);

        txtNomeConferencia.setText(conferencia.getNome());
        txtLocal.setText(conferencia.getLocal());


        return convertView;
    }
}
