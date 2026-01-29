# :closed_lock_with_key: Autenticação com Spring Security

>  Em construção...

Aplicação com template de configuração para Spring Security para API RESTful.

## Tecnologias
- Java 17
- Apache Maven
- Spring Framework
  - Springboot
  - Spring web
  - Spring security
- Lombok
- JWT
- Docker/Docker compose
- Flyway
- PostgreSQL
- H2 Database

## Features

- [x] Endpoint de authenticação
- [x] Token JWT
- [x] Hash de senha (BCrypt)
- [x] Imagem Docker
- [x] Orquestração de containers (docker compose)
- [x] Persistência (PostgreSQL) 

## Como executar

### Requisitos
- Java 17
- Apache Maven
- Docker

---

1. Clonar o projeto
  ````bash
  git clone https://github.com/filipemartinsdev/spring-security-template
  ````
   
2. Criar o pacote JAR
  ````bash
  mvn clean package
  ````

3. Executar containers
  ````bash
  docker compose up -d --build
  ````

## Arquitetura

![img_2.png](images/img_2.png)

![img_1.png](images/img_1.png)
