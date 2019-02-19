package com.project.cadastro.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
public class Aluno extends Usuario{

    private Integer matricula;
    private String curso;

//    public Aluno() {
//        super();
//    }
//
//    public Aluno(Integer codigo) {
//        super();
//
//    }
//
//    public Aluno(String login){
//        super();
//    }

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
