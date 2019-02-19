package com.project.cadastro.dao;

import com.project.cadastro.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AlunoDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

        private SqlParameterSource getSqlParameter(Aluno aluno) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        if (aluno != null) {
            System.out.println(aluno.getLogin());
            parameterSource.addValue("nome", aluno.getNome());
            parameterSource.addValue("curso", aluno.getCurso());
            parameterSource.addValue("matricula", aluno.getMatricula());
            parameterSource.addValue("senha", aluno.getSenha());
            parameterSource.addValue("login", aluno.getLogin());
            parameterSource.addValue("cpf", aluno.getCpf());

        }

        return parameterSource;
    }


    private static final class UserMapper implements RowMapper<Aluno> {

        @Override
        public Aluno mapRow(ResultSet resultSet, int i) throws SQLException {
            Aluno aluno = new Aluno();

            aluno.setCpf(resultSet.getString("cpf"));
            aluno.setMatricula(resultSet.getInt("matricula"));
            aluno.setCurso(resultSet.getString("curso"));
            aluno.setNome(resultSet.getString("nome"));
            aluno.setLogin(resultSet.getString("login"));
            aluno.setSenha(resultSet.getString("senha"));
            return aluno;
        }
    }
    public void createAluno(Aluno aluno) throws DataAccessException {

        String sql = "INSERT INTO alunos(nome, curso, matricula, senha, login, cpf )  VALUES(:nome, :curso, :matricula, :senha,:login, :cpf)";
        namedParameterJdbcTemplate.update(sql, getSqlParameter(aluno));
    }

    public void deleteAluno(String login) throws DataAccessException {

        String sql = "DELETE FROM alunos WHERE login = :login";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("login", login);
        namedParameterJdbcTemplate.update(sql,parameters);

    }

    public void updateAluno(Aluno aluno) throws DataAccessException {

        String sql = "UPDATE alunos SET nome = :nome, curso = :curso, matricula = :matricula,cpf = :cpf WHERE login = :login";
        System.out.println(aluno.getLogin());
        namedParameterJdbcTemplate.update(sql, getSqlParameter(aluno));

    }


    public Aluno findALunoByLogin(String login) {

        String sql = "SELECT * FROM alunos WHERE login = :login";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("login", login);

        return namedParameterJdbcTemplate.queryForObject(sql,parameters, new UserMapper());
    }
}







