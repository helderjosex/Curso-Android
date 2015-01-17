package br.com.conhecimentodigital.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by fernandooliveira on 10/01/15.
 */
public class HelloWorld extends Activity {

    private TextView texto;
    private EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

        texto = (TextView) findViewById(R.id.texto);
        input = (EditText) findViewById(R.id.input);

    }

    public void trocarTexto(View view) {
        String novoTexto = input.getText().toString();
        texto.setText(novoTexto);

        try {
            Thread.sleep(2000);

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("nome", novoTexto);

            startActivity(intent);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
