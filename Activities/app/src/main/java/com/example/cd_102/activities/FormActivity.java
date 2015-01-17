package com.example.cd_102.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class FormActivity extends ActionBarActivity {

    public static final int REQUEST_CODE = 0; // CONSTANTE
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Retornar a View
        editText = (EditText) findViewById(R.id.editText);
    }

    public void retornar(View v){

        String nome = editText.getText().toString();

        Intent data = new Intent();
        data.putExtra("nome",nome); // valor para ser recuperado na outra tela

        setResult(RESULT_OK,data);
        finish(); // Fechar a activity atual
    }

}
