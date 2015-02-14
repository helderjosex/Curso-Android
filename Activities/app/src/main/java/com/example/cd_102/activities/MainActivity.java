package com.example.cd_102.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;


public class MainActivity extends ActionBarActivity {

    EditText edtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = (EditText) findViewById(R.id.editText);
        Button buttonTela2 = (Button) findViewById(R.id.button5);

        Button buttonCliente = (Button) findViewById(R.id.button6);

        Button buttonPessoa = (Button) findViewById(R.id.button7);


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


    public void onClick(View view){

        switch (view.getId()){

            case R.id.button5:
                Intent it = new Intent(this,Tela2Activity.class);
                it.putExtra("nome","Helder");
                it.putExtra("idade",29);
                startActivity(it);
                break;

            case R.id.button6:
                Cliente cliente = new Cliente (1,"Hélder");
                Intent intent = new Intent(this,Tela2Activity.class);
                intent.putExtra("cliente",cliente);
                startActivity(intent);
                break;

            /*case R.id.button7:
                Pessoa pessoa = new Pessoa (30,"Hélder");
                Intent its = new Intent(this,Tela2Activity.class);
                its.putExtra("pessoa",pessoa);
                startActivity(its);
                break;*/


        }

    }


}
