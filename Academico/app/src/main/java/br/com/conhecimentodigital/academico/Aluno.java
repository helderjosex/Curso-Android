package br.com.conhecimentodigital.academico;

import java.io.Serializable;

/**
 * Created by helderjose on 25/01/15.
 */
public class Aluno implements Serializable {

    private Long id;
    private String nome;
    private String cpf;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
