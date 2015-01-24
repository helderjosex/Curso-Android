package br.com.conhecimentodigital.calculadora;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //private EditText display;
    private TextView display;
    private double n1,n2,resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display = (EditText) findViewById(R.id.display);
        display = (TextView) findViewById(R.id.displayText);
        //num1 = (Button) findViewById(R.id.num1);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void updateDisplay(View v){

        //display.setText(display.getText().toString() + ((Button)v).getText());
        display.setText(display.getText().toString() + ((Button)v).getText());
    }

    public void somar(View v){


        n1 = Double.parseDouble(display.getText().toString()+ ((Button)v).getText());
        n2 = Double.parseDouble(display.getText().toString()+ ((Button)v).getText());

        resultado = n1 + n2;

        display.setText(String.valueOf(resultado));

    }

}
