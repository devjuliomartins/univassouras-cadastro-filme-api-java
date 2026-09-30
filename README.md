# 🎬 Cadastro de Filmes API

API REST desenvolvida em **Java** para cadastro e gerenciamento de filmes. Projeto desenvolvido durante a graduação em **Engenharia de Software na Universidade de Vassouras**.

## 🚀 Tecnologias

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Maven
- Banco de dados relacional

## 📋 Sobre o projeto

O projeto consiste no desenvolvimento de uma API REST para gerenciamento de filmes, permitindo realizar operações de cadastro, consulta, atualização e exclusão de registros.

A aplicação foi desenvolvida com o objetivo de praticar conceitos de desenvolvimento de APIs utilizando **Java e Spring Boot**, além da integração com banco de dados por meio do **Spring Data JPA**.

## ⚙️ Funcionalidades

- [x] Cadastrar filme
- [x] Listar filmes
- [x] Buscar filme por ID
- [x] Atualizar filme
- [x] Excluir filme

## 🔗 Endpoints

| Método | Endpoint | Descrição |
|:------:|----------|-----------|
| `GET` | `/filmes` | Lista todos os filmes |
| `GET` | `/filmes/{id}` | Busca um filme pelo ID |
| `POST` | `/filmes` | Cadastra um novo filme |
| `PUT` | `/filmes/{id}` | Atualiza um filme |
| `DELETE` | `/filmes/{id}` | Remove um filme |

## 📥 Exemplo de cadastro

### Requisição

```http
POST /filmes
Content-Type: application/json
{
  "titulo": "Interestelar",
  "genero": "Ficção Científica",
  "anoLancamento": 2014
}
