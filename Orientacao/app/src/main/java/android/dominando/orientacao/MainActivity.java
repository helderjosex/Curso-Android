package android.dominando.orientacao;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.sql.Struct;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    EditText edt;
    ArrayList<String> nomes;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Salvar Dados ao rotacionar a tela
        if(savedInstanceState !=null){
            nomes = savedInstanceState.getStringArrayList("nomes");
        }else
        {
            nomes = new ArrayList<String>();
        }


        edt = (EditText) findViewById(R.id.editText1);

        ListView listView = (ListView) findViewById(R.id.listView1);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nomes);
        listView.setAdapter(adapter);


    }

    public void meuBotaoClick(View v){

        nomes.add(edt.getText().toString());
        edt.setText("");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes",nomes);
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
}
