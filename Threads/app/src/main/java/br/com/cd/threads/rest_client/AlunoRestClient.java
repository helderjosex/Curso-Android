package br.com.cd.threads.rest_client;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.cd.threads.helpers.HttpHelper;
import br.com.cd.threads.model.Aluno;

/**
 * Created by cd-101 on 22/02/2015.
 */
public class AlunoRestClient {


    public Aluno findById(int id){
        String json = HttpHelper.doGet("alunos/" + id + ".json");

        try {
            JSONObject jsonObject = new JSONObject(json);
            Aluno aluno = Aluno.parseJsonObject(jsonObject);

            return aluno;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;

    }

    public List<Aluno> findAll(){

        String json = HttpHelper.doGet("alunos.json");
        Log.d("JSON", json);

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        List<Aluno> alunos = new ArrayList<>();
        for(int i=0; i < jsonArray.length();i++){
            JSONObject obj = null;
            try {
                obj = (JSONObject) jsonArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            alunos.add(Aluno.parseJsonObject(obj));
        }
        return alunos;

    }


}
