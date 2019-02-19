package com.project.cadastro.repository;

import com.project.cadastro.model.Aluno;

import java.util.List;

public interface AlunoRepository {

    public List<Aluno> listAllUsers();

    public void addUser(Aluno user);

    public void updateUser(Aluno user);

    public void deleteUser(String login);

    public Aluno findUserByLogin(String login);
}

