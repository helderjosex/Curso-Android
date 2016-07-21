package br.com.helderjose.testesunitarios.models;

/**
 * Created by helder on 20/07/16.
 */
public class Pessoa {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade){

        if (idade < 0){
            throw new IllegalArgumentException("Pessoa não pode ter idade negativa");
        }
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean podeVotar(){
        return this.idade >= 16;
    }
}
