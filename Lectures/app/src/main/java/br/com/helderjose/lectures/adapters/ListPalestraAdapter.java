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
import br.com.helderjose.lectures.models.Palestra;

/**
 * Created by helder on 20/07/16.
 */
public class ListPalestraAdapter extends BaseAdapter {

    private Activity activity;
    private List<Palestra> palestras;

    public static ListPalestraAdapter getInstance(Activity activity, List<Palestra> palestras) {
        ListPalestraAdapter adapter = new ListPalestraAdapter();
        adapter.activity = activity;
        adapter.palestras = palestras;
        return adapter;
    }

    private ListPalestraAdapter() {}

    @Override
    public int getCount() {
        return palestras.size();
    }

    @Override
    public Object getItem(int position) {
        return palestras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return palestras.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.palestras_list_item, null);
        }
        Palestra palestra = (Palestra) getItem(position);
        TextView txtNomePalestra = (TextView) convertView.findViewById(R.id.txtNomePalestra);
        TextView txtHoraPalestra = (TextView) convertView.findViewById(R.id.txtHoraPalestra);
        txtNomePalestra.setText(palestra.getNome());
        txtHoraPalestra.setText(palestra.getHoraInicial());

        return convertView;
    }
}
