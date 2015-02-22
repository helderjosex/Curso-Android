package br.com.cd.threads.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Classe COMMON reutilizada em todos os projetos
 */
public class HttpHelper {

    public static final String BASE_URL = "http://192.168.252.2:3000/";

    public static String doGet(String resource){
        String response = null;

        try {
            URL url = new URL(BASE_URL + resource);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.connect();
            response = readStream(con.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private static String readStream (InputStream inputStream) throws IOException{
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();

        // API NATIVA DO JAVA LER ARQUIVO
        try {
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = reader.readLine()) != null){
                builder.append(line+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }

        return builder.toString();
    }

}

