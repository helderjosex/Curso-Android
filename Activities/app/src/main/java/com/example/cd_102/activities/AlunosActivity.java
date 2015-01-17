package com.example.cd_102.activities;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class AlunosActivity extends ListActivity {

    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verificar os dados temporarios estão criados
        if(savedInstanceState != null)
        {
            data = (String[]) savedInstanceState.getSerializable("data");
        }else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        data = new String[]{"Helder","Cesar","Guilherme","Hermogenes","Bruno"};
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        setListAdapter(adapter);

    }

    // Salvar temproário dados da tela
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable("data",data);
    }

    // Pegar Item da Lista
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(this,data[position],Toast.LENGTH_LONG).show();
    }
}
