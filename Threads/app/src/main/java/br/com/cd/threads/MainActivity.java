package br.com.cd.threads;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.cd.threads.activities.AlunoActivity;
import br.com.cd.threads.tasks.DownloadImageTask;


public class MainActivity extends ActionBarActivity {

    private ProgressBar progressBar;
    private TextView txtPercentual;
    private Handler handler;
    private ImageView imageView;
    private TextView quantidadeAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        txtPercentual =(TextView) findViewById(R.id.txtPercentual);
        imageView = (ImageView) findViewById(R.id.imageView);
        handler = new Handler();

        quantidadeAlunos = (TextView) findViewById(R.id.qtdAlunos);

        SharedPreferences preferences = getSharedPreferences("prefs", MODE_PRIVATE);
        quantidadeAlunos.setText(String.valueOf(preferences.getInt("quantidade_alunos",0)));

    }


    public void activeProgressBar(View v){

        new Thread(){
            @Override
            public void run() {
                int progress=0;
                for (int i = 0; i < 10;i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress+=10;
                    final int finalProgress = progress;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(finalProgress);
                            txtPercentual.setText(finalProgress + "%");
                        }
                    }
                    );

                    // Atalho do metodo handler.post
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,finalProgress + "%",Toast.LENGTH_SHORT).show();
                        }
                    });


                }

            }
        }.start();
    }

    public void downloadImageAsyncTask(View v){

        new DownloadImageTask(MainActivity.this).execute(imageView);

    }

    public void listAlunos(View v){

        Intent intent = new Intent(this, AlunoActivity.class);
        startActivity(intent);

    }

}
