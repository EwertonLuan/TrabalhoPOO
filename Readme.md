# Sistema de cadastro com Spring boot e Spring mvc 

### Este projeto contem telas de cadastro, edição e login

Para login do usuario foi utilizado o Spring security, a senha foi encriptada com BCryptPasswordEncoder, NamedParameterJdbcTemplate para realizar as interações da classe Dao e HikariDataSource para realizar a coneção com o DB  

## Instalação e uso 

Pre-requisitos
* Maven
* Mysql
* JavaSDK 1.8

Após a configuração do Mysql crie o uma tabel com o comando:

 ```
 $  CREATE TABLE database.alunos (nome varchar(45) NOT NULL DEFAULT '',
 curso varchar(100) NOT NULL DEFAULT '',
 matricula int(100) NOT NULL DEFAULT 0,
 senha varchar(100) NOT NULL DEFAULT '',
 login varchar(100) NOT NULL DEFAULT '',
 cpf varchar(100) NOT NULL DEFAULT '',
 PRIMARY KEY (login)) DEFAULT CHARSET=utf8;
 ```

### Rotas 

`GET /`

Rota principal, tela com link para cadastro e login no sistema

`GET /aluno`

Rota com tela para cadastro de aluno

`POST /aluno`

Rota para envio dos dados do alunos para o banco de dados 

`GET /aluno/perfil`

Rota com tela para exibição e edição de dados do aluno

`POST /aluno/perfil`

Atualizar um usuario por login

`GET /deletarAluno`

Deletar um aluno por login

### Referncias
* [Spring 4 MVC CRUD Operations with Spring JDBC Template and Mysql Database Tutorial](https://www.jackrutorial.com/2018/01/spring-mvc-crud-operations-with-spring-jdbc-template-and-mysql-database-tutorial.html)
* [Curso Spring Boot](https://github.com/MichelliBrito/cursospringboot)
* [Tipos de Herança com o hibernate](https://www.devmedia.com.br/tipos-de-heranca-no-hibernate/28641)
* [Implementando o Data Access Object no Java EE](https://www.devmedia.com.br/implementando-o-data-access-object-no-java-ee/33339)
