package com.project.cadastro.repository;

import com.project.cadastro.model.Aluno;

public interface AlunoRepository {

    void addUser(Aluno user);

    void updateUser(Aluno user);

    void deleteUser(String login);

    Aluno findUserByLogin(String login);
}

