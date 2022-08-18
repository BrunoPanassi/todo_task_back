# TODO Task

Projeto criado para estudos de Back-End com um sistema CRUD de tarefas utilizando Spring Boot, JPA, Hibernate e MySql.





## Instalação

Para ter o banco de dados, tenha o Docker instalado e rode
o comando abaixo:

```bash
  sudo docker run -d -p 3306:3306 --name mysql_test 
  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=test mysql
```

Após o container criado, com o seu id, rode o comando abaixo:
 ```bash
    sudo docker container start {container-id}
 ```

Com o projeto do Spring Boot em mãos, e todas as dependências
instaladas, execute o arquivo main,
**TodoListApplication**.

Ou possa optar por rodar o comando:
```bash
    mvn spring-boot:run
```

Para a inserção de dados iniciais, use o script **insert-data.sql**
    