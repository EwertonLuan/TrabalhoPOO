package com.project.cadastro.services;

import com.project.cadastro.dao.AlunoDao;
import com.project.cadastro.model.Aluno;
import com.project.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AlunoService implements AlunoRepository {

    private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();

    private AlunoDao alunoDao;

    @Autowired
    public void setAlunoDao(AlunoDao alunoDao){
        this.alunoDao = alunoDao;
    }

    @Override
    public void addUser(Aluno aluno) {
        String password = encoder.encode(aluno.getSenha());
        aluno.setSenha(password);
        alunoDao.createAluno(aluno);
    }

    @Override
    public void updateUser(Aluno aluno) {
        alunoDao.updateAluno(aluno);
    }

    @Override
    public void deleteUser(String login) {
        alunoDao.deleteAluno(login);
    }

    @Override
    public Aluno findUserByLogin(String login) {

        return alunoDao.findALunoByLogin(login);

    }
}
