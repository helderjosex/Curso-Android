package br.com.conhecimentodigital.academico;

import android.graphics.Bitmap;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class ViewsActivity extends ActionBarActivity {

    private SeekBar seekBar;
    private TextView seekValue;
    private RadioGroup radioGroup;
    private Spinner spinner;

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekValue = (TextView) findViewById(R.id.seekValue);
        configSeekBar();

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        configRadioGroup();

        spinner = (Spinner) findViewById(R.id.spinner);
        String [] alunos = new String[] {"Helder", "Hermogenes", "Guilherme", "Bruno", "Rubens", "Cesar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, alunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.conhecimentodigital.com.br");

        webView.setWebViewClient(new MyWebViewClient());
    }

    private void configRadioGroup() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton button = (RadioButton) findViewById(checkedId);

                Toast.makeText(ViewsActivity.this, "Sexo: " + button.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void configSeekBar() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue.setText("R$ " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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

    public class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Toast.makeText(ViewsActivity.this, "Loading...", Toast.LENGTH_LONG).show();
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            Toast.makeText(ViewsActivity.this, "Page Start...", Toast.LENGTH_LONG).show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            Toast.makeText(ViewsActivity.this, "Page Finished...", Toast.LENGTH_LONG).show();
            super.onPageFinished(view, url);
        }
    }
}
