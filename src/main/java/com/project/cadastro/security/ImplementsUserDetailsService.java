package com.project.cadastro.security;


import com.project.cadastro.model.Aluno;
import com.project.cadastro.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ImplementsUserDetailsService implements UserDetailsService {


    @Autowired
    AlunoService alunoService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Aluno aluno = alunoService.findUserByLogin(login);


        if(aluno == null){
            System.out.println("null");

            throw new UsernameNotFoundException("Usuario não encontrado!");
        }
        System.out.println(aluno.getUsername());

        return new User(aluno.getUsername(), aluno.getPassword(), true, true, true, true, aluno.getAuthorities());

    }

}