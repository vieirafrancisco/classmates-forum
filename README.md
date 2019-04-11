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

## Run with Makefile
For execute the API or app using Makefile you just need run following commands in root of  project:

- For API: ```make run-api```
- For app: ```make run-app```

This will install the required depedencies and run server with the API or application.

## API

Change for the directory **api** and run following command to: 

- Build jar with Maven:
    
        mvn package -DskipTests

- Run API on server:

        mvn spring-boot:run

## Applicaation
Change for the directory **front-end** and run following command to:

- Install dependencies:

        npm -i -g

- Run application with Electron:

        npm run electron:serve

## Section for discipline 'Banco de Dados 1'

## Section for discipline 'Engenharia de Software'

## Contributors 
- [Francisco Neto](https://github.com/vieirafrancisco)
- [Jadson Lúcio](https://github.com/jadsonlucio)
- [Luís Eduardo](https://github.com/luiseduardogfranca)
- [Roque Barbosa](https://github.com/trucopa)
