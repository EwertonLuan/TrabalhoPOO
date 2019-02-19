package com.project.cadastro.dao;

import com.project.cadastro.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AlunoDao{

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
//            parameterSource.addValue("codigo", aluno.getCodigo());
            parameterSource.addValue("login", aluno.getLogin());
            parameterSource.addValue("cpf", aluno.getCpf());

        }

        return parameterSource;
    }


    private static final class UserMapper implements RowMapper<Aluno> {

        @Override
        public Aluno mapRow(ResultSet resultSet, int i) throws SQLException {
            Aluno aluno = new Aluno();
//            Role role = new Role();
//            List<Role> list = new ArrayList<>();
//            role.setNomeRole("USER");
//            list.add(role);
//            aluno.setRoles(list);
//            aluno.setCodigo(resultSet.getInt("codigo"));
//            System.out.println(resultSet.getInt("codigo"));

            aluno.setCpf(resultSet.getString("cpf"));
//            System.out.println(resultSet.getString("cpf"));

            aluno.setMatricula(resultSet.getInt("matricula"));
//            System.out.println(resultSet.getInt("matricula"));

            aluno.setCurso(resultSet.getString("curso"));
//            System.out.println(resultSet.getString("curso"));

            aluno.setNome(resultSet.getString("nome"));
//            System.out.println(resultSet.getString("nome"));

            aluno.setLogin(resultSet.getString("login"));
//            System.out.println(resultSet.getString("login"));

            aluno.setSenha(resultSet.getString("senha"));
//            System.out.println(resultSet.getString("senha"));

            return aluno;
        }
    }
    public void create(Aluno aluno) throws DataAccessException {

        String sql = "INSERT INTO alunos(nome, curso, matricula, senha, login, cpf )  VALUES(:nome, :curso, :matricula, :senha,:login, :cpf)";
        namedParameterJdbcTemplate.update(sql, getSqlParameter(aluno));
    }

    public void deleteAluno(String login) throws DataAccessException {

        String sql = "DELETE FROM alunos WHERE login = :login";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("login", login);
        namedParameterJdbcTemplate.update(sql,parameters);

    }

//    public void updateAluo(Aluno aluno) throws DataAccessException {
//
//        String sql = "UPDATE aluno SET nome = :nome, curso = :curso, matricula = :matricula,login = :login,cpf = :cpf WHERE codigo = :codigo";
//
//        if (namedParameterJdbcTemplate.update(sql, getSqlParameter(aluno)) > 0) {
//            System.out.println("Deu bom");
//        } else {
//            System.out.println("Deu ruim");
//        }
//    }

    public void updateAluno(Aluno aluno) throws DataAccessException {

        String sql = "UPDATE alunos SET nome = :nome, curso = :curso, matricula = :matricula,cpf = :cpf WHERE login = :login";
        System.out.println(aluno.getLogin());
        if (namedParameterJdbcTemplate.update(sql, getSqlParameter(aluno)) > 0) {
            System.out.println("Deu bom");
        } else {
            System.out.println("Deu ruim");
        }
    }

    public Aluno findUserById(int codigo) {

        String sql = "SELECT * FROM alunos WHERE codigo = :codigo";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("codigo", codigo);

        return namedParameterJdbcTemplate.queryForObject(sql,parameters, new UserMapper());
    }

    public Aluno findUserByLogin(String login) {

        System.out.println(encoder.matches("123", "$2a$10$MZMOJVTbFx0uFnScXffBL.NrdTAUrWPVyO2OcEq/xuf70BpN4ZfN."));

        String sql = "SELECT * FROM alunos WHERE login = :login";
        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("login", login);

        return namedParameterJdbcTemplate.queryForObject(sql,parameters, new UserMapper());
    }
    public List<Aluno> listAllUsers() {
        String sql = "SELECT * FROM aluno";

        List<Aluno> list = namedParameterJdbcTemplate.query(sql, getSqlParameter(null), new UserMapper());

        return list;
    }

}







