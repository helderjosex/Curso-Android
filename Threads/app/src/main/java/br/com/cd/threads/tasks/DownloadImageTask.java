package br.com.cd.threads.tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.cd.threads.helpers.HttpHelper;
import br.com.cd.threads.model.Aluno;

/**
 * Created by cd-101 on 21/02/2015.
 */
public class DownloadImageTask extends AsyncTask<ImageView,Void,Bitmap> {

    private ProgressDialog pDialog;
    private Activity activity;
    private ImageView imageView;

    public DownloadImageTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(activity);
        pDialog.setTitle("Por Favor, aguarde!");
        pDialog.setMessage("Baixando imagem ...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected Bitmap doInBackground(ImageView... params) {
        imageView = params[0];
        try {

            URL imageURL = new URL("http://4.bp.blogspot.com/-Ow4AIQUNNLc/TlUJJQT1vUI/AAAAAAAAF-c/PyqIEd8XtjU/s200/cursos-online.jpg");
            HttpURLConnection con = (HttpURLConnection) imageURL.openConnection();
            con.connect();
            InputStream inputStream = con.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        pDialog.dismiss();
        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
        }
    }
}
