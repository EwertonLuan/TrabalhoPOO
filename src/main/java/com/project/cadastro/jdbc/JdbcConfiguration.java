package com.project.cadastro.jdbc;


import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.naming.NamingException;
import javax.sql.DataSource;


@Configuration
@EnableWebMvc
public class JdbcConfiguration {

    @Autowired
    DataSource dataSource;


    @Bean
    public NamedParameterJdbcTemplate geNamedParameterJdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public DataSource buildDataSource() throws NamingException {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/databse");
        dataSource.setUsername("usuario");
        dataSource.setPassword("password");
        System.out.println("Conectou com o db");

        return dataSource;
    }


}
