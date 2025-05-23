# 📚 Projeto Web II - Atualizado para Testes Automatizados I
## 🔹 API de Cadastro de Jogos 🎮

## 🚧 Concluído - Aberto para futuras atualizações🚧

---

## ✅ Visão Geral
### 🔹 Este projeto é uma aplicação web desenvolvida com Spring Boot 3.4.4 que oferece uma API RESTful para o gerenciamento de um catálogo de jogos. O sistema permite cadastrar, listar, atualizar, excluir e buscar jogos por ID, persistindo os dados em um banco H2 em memória.

---

## 🧱 Estrutura do Projeto
#### 🔹 myprojetowebii/
####    ├── cadastro/
####    │   ├── config/              → Tratamento de exceções globais
####    │   ├── controller/          → Endpoints REST
####    │   ├── dto/                 → Objetos de transferência de dados (DTOs)
####    │   │   └── mapper/          → Conversão entre DTOs e entidades
####    │   ├── exception/           → Exceções personalizadas
####    │   ├── model/               → Entidade Jogo
####    │   ├── repository/          → Interface de persistência (JPA)
####    │   ├── service/             → Lógica de negócio (services)
####    │   └── CadastroApplication  → Classe principal (main)
####    │   └── resources            → Arquivos de configuração
####    │   └── README.md            → Documentação

---

## 🚀 Tecnologias Utilizadas
### 🔹 Java 21
### 🔹 Spring Boot 3.4.4
### 🔹 Spring Web
### 🔹 Spring Data JPA
### 🔹 H2 Database (runtime)
### 🔹 Bean Validation (Jakarta Validation)
### 🔹 Jakarta Validation
### 🔹 Maven
### 🔹 JUnit 5 + Mockito (para testes)

---

## 🔗 Endpoints da API

### ➕ Criar Jogo
### 🔹 POST /jogos
### 🔹 Cadastrar um novo jogo, Ex:

###     {
###         "nome": "The Witcher 3",
###         "genero": "RPG",
###         "dataLancamento": "2015-05-19",
###         "preco": 149.90,
###         "plataforma": "PC"
###     }

### 🔹 Status 201: Criado com sucesso
### 🔹 Validações: Campos obrigatórios com mensagens personalizadas

---

## 📋 Listar Jogos
### 🔹 GET /jogos
### 🔹 Listar todos os jogos cadastrados
### 🔹 Retorna uma lista de objetos JogoDTO
### 🔹 Status 200: Sucesso

---

## 🔎 Buscar por ID
### 🔹 GET /jogos/{id}
### 🔹 Buscar jogo por ID
### 🔹 Status 200: Se encontrado
### 🔹 Status 404: Se o jogo não existir

---

## ✏️ Atualizar Jogo
### 🔹 PUT /jogos/{id}
### 🔹 Atualizar dados de um jogo

###     {
###         "nome": "The Witcher 3",
###         "genero": "RPG",
###         "dataLancamento": "2015-05-19",
###         "preco": 149.90,
###         "plataforma": "PC"
###     }
### 🔹 Status 200: Atualização bem-sucedida
### 🔹 Status 404: Jogo não encontrado

---

## ❌ Excluir Jogo
### 🔹 DELETE /jogos/{id}
### 🔹 Excluir jogo pelo ID    
### 🔹 Status 200: Jogo removido    
### 🔹 Status 404: Se o ID não existir

---

## 🧠 Validações:
### 🔹 Todos os campos são validados com mensagens personalizadas. Exemplo:
### 🔹 Nome, Gênero e Plataforma: mínimo de 3 caracteres
### 🔹 Data de lançamento: obrigatória
### 🔹 Preço: deve ser maior que zero

---

## 📦 Modelo de Dados / 🎮 Entidade: Jogo
### |---------------------------------------------------------------|
### | Campo	            | Tipo	    | Descrição                     |
### |---------------------------------------------------------------|
### | id	            | Long	    | Identificador único           |
### | nome	            | String	| Nome do jogo                  |
### | genero	        | String	| Gênero (ex: RPG, Ação)        |
### | dataLancamento	| LocalDate	| Data de lançamento            |
### | preco	            | Double	| Preço do jogo                 |
### | plataforma	    | String	| Plataforma (ex: PC, PS5, etc) |
### |---------------------------------------------------------------|

---

## 🚨 Tratamento de Exceções
### 🔹 JogoNaoEncontradoException: Exceção customizada lançada quando o ID não existe.
### 🔹 Mapeada globalmente com @ControllerAdvice.

---

## 🔧 Como Executar o Projeto
### 🔹 Pré-requisitos
### 🔹 Java 21+
### 🔹 Maven

## Comandos:
### 🔹 Build do projeto:     mvn clean install
### 🔹 Executar a aplicação: mvn spring-boot:run

## Acesso:
### 🔹 API disponível em: http://localhost:8080/jogos
### 🔹 Console H2: http://localhost:8080/h2-console

---

## 📄 Exemplo de JSON:

###     {
###         "nome": "God of War",
###         "genero": "Ação",
###         "dataLancamento": "2018-04-20",
###         "preco": 199.99,
###         "plataforma": "PlayStation 4"
###     }

---

## 👨‍💻  Curso :  Ada Tech Desenvolva +
### 🔹 Projeto desenvolvido para a disciplina de Projeto Web II - Atualizado para Testes Automatizados I - Ada Tech.