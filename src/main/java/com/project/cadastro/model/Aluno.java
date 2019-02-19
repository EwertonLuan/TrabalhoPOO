package com.project.cadastro.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Usuario{

    private Integer matricula;
    private String curso;

    public Integer getMatricula() {

        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

}
