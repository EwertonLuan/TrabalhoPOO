package com.project.cadastro.repository;

import com.project.cadastro.model.Usuario;



public interface UsuarioRepository {

    Usuario findByLogin(String login);
}