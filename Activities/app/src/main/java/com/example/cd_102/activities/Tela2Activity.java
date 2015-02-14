package com.example.cd_102.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Tela2Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        TextView txt = (TextView) findViewById(R.id.textView3);

        Intent it = getIntent();

        Cliente cliente  = it.getParcelableExtra("cliente");
        if(cliente !=null){
            String texto = String.format("Nome: %s / Código: %d", cliente.nome,cliente.codigo);
            txt.setText(texto);
        }else
        {
            String nome = it.getStringExtra("nome");
            int idade  = it.getIntExtra("idade",-1);
            txt.setText(String.format("Nome: %s / Idade: %d", nome,idade));
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela2, menu);
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
