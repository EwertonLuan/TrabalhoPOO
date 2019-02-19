package com.project.cadastro.services;

import com.project.cadastro.dao.AlunoDao;
import com.project.cadastro.model.Aluno;
import com.project.cadastro.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoService implements AlunoRepository {

    private BCryptPasswordEncoder encoder =  new BCryptPasswordEncoder();

    private AlunoDao alunoDao;

    @Autowired
    public void setAlunoDao(AlunoDao alunoDao){
        this.alunoDao = alunoDao;
    }


//    public void alunoCadastro(Aluno aluno) {
//        String password = encoder.encode(aluno.getSenha());
//        aluno.setSenha(password);
//        alunoDao.create(aluno);
//    }
//    public List<Aluno> listUser(){
//        return alunoDao.listAllUsers();
//
//    }
//    public Aluno Login(String login) {
//
//        return alunoDao.findUserByLogin(login);
//    }

    @Override
    public List<Aluno> listAllUsers() {
        return alunoDao.listAllUsers();
    }

    @Override
    public void addUser(Aluno aluno) {
        String password = encoder.encode(aluno.getSenha());
        aluno.setSenha(password);
        alunoDao.create(aluno);
    }

    @Override
    public void updateUser(Aluno aluno) {

//        alunoDao.updateAluo(aluno);
    }
    public void updateAluno(Aluno aluno) {

        alunoDao.updateAluno(aluno);
    }


    @Override
    public void deleteUser(String login) {
        alunoDao.deleteAluno(login);
    }

//    @Override
//    public Aluno findUserById(int id) {
////        HttpSession session = (HttpSession);
////        System.out.println(session.getAttributeNames());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth.getPrincipal());
//
//        return alunoDao.findUserById(id);
//    }

    @Override
    public Aluno findUserByLogin(String login) {

        return alunoDao.findUserByLogin(login);

    }
}
