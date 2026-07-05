# Cliente REST API - Locadoras

Projeto referente à Atividade T8. É uma aplicação web independente desenvolvida exclusivamente para consumir a API REST do projeto principal (T7).

## Funcionalidades
Foi escolhida a entidade **Locadora**. Este cliente realiza as 4 operações do CRUD (Create, Read, Update, Delete) comunicando-se com a API externa através do envio e recebimento de objetos JSON. 

## Tecnologias
- Java 17, Spring Boot 3.2.5 (Web)
- `RestClient` (Cliente HTTP fluente do Spring)
- Thymeleaf + Bootstrap para a interface gráfica

## Execução
**Importante:** O servidor da API Principal (T7) deve estar rodando obrigatoriamente na porta `8080` antes de iniciar este cliente.

Para rodar este cliente:
- mvn clean spring-boot:run
- O cliente subirá na porta 8081 para evitar conflito.
- Acesse no navegador: http://localhost:8081
