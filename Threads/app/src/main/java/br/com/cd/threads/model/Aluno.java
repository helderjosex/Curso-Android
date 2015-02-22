package br.com.cd.threads.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cd-101 on 21/02/2015.
 */
public class Aluno {
    private int id;
    private String nome;
    private String matricula;
    private String email;
    private String foto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public static Aluno parseJsonObject(JSONObject jsonObject){
        Aluno aluno = new Aluno();

        try {
            // Verificar se a chave no JSON esta null
            //jsonObject.has("nome");
            aluno.setId(jsonObject.getInt("id")); // Chaves que vem do JSON
            aluno.setNome(jsonObject.getString("nome"));
            aluno.setEmail(jsonObject.getString("email"));
            aluno.setFoto(jsonObject.getString("foto"));
            aluno.setMatricula(jsonObject.getString("matricula"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return aluno;

    }
}
