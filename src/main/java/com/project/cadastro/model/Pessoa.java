package com.project.cadastro.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    private String nome;
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
