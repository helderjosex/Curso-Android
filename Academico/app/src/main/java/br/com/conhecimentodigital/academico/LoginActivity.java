package br.com.conhecimentodigital.academico;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends ActionBarActivity {

    private EditText edtLogin;
    private EditText edtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtLogin = (EditText) findViewById(R.id.inputLogin);
        edtPassword = (EditText) findViewById(R.id.inputPassword);
    }

    public void login (View v){
        if(edtLogin.getText().toString().equals("admin@cd.com.br") && edtPassword.getText().toString().equals("123")){
            Toast.makeText(this,"Login efetuado com sucesso",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            //Toast.makeText(this,"Não foi possivel efetuar o login",Toast.LENGTH_LONG).show();
            edtPassword.setError("Senha ou email incorreto(s)");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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
