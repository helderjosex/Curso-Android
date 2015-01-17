package com.example.cd_102.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.URI;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void mostrarForm (View v){
       Intent intent = new Intent(this,FormActivity.class);
       // Trazer o resultado digitado da outra tela
       startActivityForResult(intent,FormActivity.REQUEST_CODE);
   }

    // Mostrar resultado na Tela
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, "Nome: " + data.getStringExtra("nome"),Toast.LENGTH_LONG).show();
    }

    public void mostrarLista (View v)
    {
        Intent intent = new Intent(this, AlunosActivity.class);

        startActivity(intent);
    }
    // ABRIR O DISCADOR
    public void ligarProfessor(View w)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+558288417959"));

        startActivity(intent);
    }

}
