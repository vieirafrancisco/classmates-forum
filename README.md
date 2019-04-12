<div style="text-align: center">
<h1>Classmates Forum</h1>
<p>This is a forum for students discuss topics and share their concerns with their classmates.</p> 
</div>

## Structure project 

The folder **api** contain all code of API developed in Java with framework SpringBoot. The folder **front-end** contain the application maked with Vuejs.

```
.
|-- classmates-forum
    |-- api
    |   |
    |   `-- ...
    |
    `-- front-end 
        | 
        `-- ...
```


## Requirments 
- API:
  - Maven 
  - Java 11

- Application front-end:
  - npm 

## Build and run application with Makefile
For execute the API or app using Makefile you just need run following commands in root of  project:

- For build the API:  ```make build-api```
- For build the app:   ```make build-app```
- For run the API:   ```make run-api```
- For run the app:   ```make run-app```

This will install the required depedencies and run server with the API or application.

When execute the servers:

- api: localhost:8080
- app: localhost:8081

## API

Change for the directory **api** and run following command to: 

- Build jar with Maven:
    
        mvn package -DskipTests

- Run API on server:

        mvn spring-boot:run

## Application
Change for the directory **front-end** and run following command to:

- Install dependencies:

        npm -i -g

- Run application with Electron:

        npm run electron:serve

## Option to use only the API - Postman 
If you're just using the API we recommend to install [Postman](https://www.getpostman.com/) and import the json file in *api/Classmates API Documentation.postman_collection* to get access to the API's collection with all requests.

### Some requests with GET method:
- localhost:8080/users (Return a list of users, permission: Logged Account/Admin)
- localhost:8080/topics (Return a list of topics, permission: free permission)
- localhost:8080/posts (Return a list of posts, permission: free permission)

and so on...

## Seção para os projetos das disciplinas - UFAL

O projeto em Java é basicamente uma API REST, feita em SpringBoot, que possibilita criar usuários, criar tópicos, criar posts dentro de tópicos, fazer comentários em posts entre outras coisas (mais informações no [documento](https://github.com/vieirafrancisco/classmates-forum/blob/develop/api/doc/documento.pdf)) e está estruturado da seguinte forma:
```
.
|-- api
    |-- doc
    |-- src
        |-- main
            |-- java (/com/ufal/classmates_forum)
            |-- resources
        |-- test (/java/com/ufal/classmates_forum)
    `-- pom.xml
```

Onde **doc/** é guardado os artefatos utilizado no projeto, em **src/** existe o **main/java/com/ufal/classmates_forum** que é onde está toda a codificação e o **test/java/com/ufal/classmates_forum** onde está localizado os testes, e o pom.xml é onde fica as dependências.

A estrutura dentro do **main/java/com/ufal/classmates_forum**:

```
.
|-- src
    |-- main (/java/com/ufal/classmates_forum)
        |-- controller
        |-- domain
        |-- exceptions
        |-- repository
        `-- ClassmatesForumApplication.java
        `-- LoginInterceptor.java
        `-- ServicePermition.java
        `-- UserLogin.java
```

Em que **domain/** é onde fica as entidade e **repository/** onde fica as interfaces do Jpa (para CRUD das entidades) que representam o model do sistema;  
O **controller/** é onde está todos os controladores, que vai alimentar as requisições feitas pela aplicação;  
Em **exceptions/** estão as exceções específicas, criadas para o sistema;  
**ClassmatesForumApplication.java** é a classe principal, criada pelo próprio SpringBoot;  
**LoginInterceptor.java** e **ServicePermition.java** são classes que fazem/auxiliam o bloqueio de rotas para alguns tipos de requisições;    
**UserLogin.java** é a classe que armazena os usuários que estão logados no sistema.

### Padrão de Projeto
Além dos padrões de projeto presentes no próprio framework, sentimos a necessidade implementar um *Singleton* em  */java/com/ufal/classmates_forum/UserLogin.java* que armazena os usuários que estão logados no sistema.

### Banco de Dados

Modelo Conceitual:  
O modelo conceitual utilizado no sistema está no arquivo */api/doc/modelo_entidade-relacionamento.dia*  

SGBD:  
O que está sendo usado é o H2, que é feito o armazenamento em memória, mas têm a opção de mudar para o MySQL em */api/src/main/resources/application.properties* mudando o valor do *spring.profiles.active* de **dev** para **deploy**. Porém, por víes de facilidade, recomendamos deixar o padrão com o H2, principalmente para teste de usabilidade.  

Hibernate:  
O projeto de banco de dados foi feito em Hibernate

## Tools
Beyond github with gitflow, we create a [trello board](https://trello.com/b/L4S9JEFu/classmates-forum) to organize team project management, together with scrum techniques in attempt to do a agile development.

## Contributors 
- [Francisco Neto](https://github.com/vieirafrancisco)
- [Jadson Lúcio](https://github.com/jadsonlucio)
- [Luís Eduardo](https://github.com/luiseduardogfranca)
- [Roque Barbosa](https://github.com/trucopa)
