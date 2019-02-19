package com.project.cadastro.model;

import org.springframework.security.core.GrantedAuthority;


public class Role implements GrantedAuthority {

    private String nomeRole;


    public Role(){
        this.nomeRole= "USER";
    }
    @Override
    public String getAuthority() {
        // TODO Auto-generated method stub
        return this.nomeRole;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }
}
