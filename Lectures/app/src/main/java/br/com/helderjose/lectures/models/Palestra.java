package br.com.helderjose.lectures.models;

import java.io.Serializable;

/**
 * Created by helder on 20/07/16.
 */
public class Palestra implements Serializable {
    private Long id;
    private String nome;
    private String horaInicial;

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

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public boolean isNomeValido() {
        return this.nome.matches("[A-Z a-z Çç]{"+this.nome.length()+"}");
    }
}
