# 📦 Sistema de Gestão de Stock (Inventory Management)

> Uma aplicação web Fullstack desenvolvida em Java e Spring Boot para gestão eficiente de inventário, controlo de produtos e organização por categorias.

![Status](https://img.shields.io/badge/STATUS-CONCLUÍDO-green)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring-Boot_3-green)

## 💻 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de criar uma solução robusta para pequenos negócios gerirem o seu stock. A aplicação permite não só o registo de produtos, mas também fornece inteligência de negócio imediata, como o cálculo do valor total do inventário e alertas visuais para reposição de stock.

O foco principal foi a implementação de uma arquitetura **MVC (Model-View-Controller)** limpa, boas práticas de **REST**, e uma interface de utilizador moderna e responsiva.

---

## ✨ Funcionalidades Principais

### 🛒 Gestão de Produtos (CRUD Completo)
* **Listagem:** Visualização clara de todos os produtos com tabela moderna.
* **Criação:** Adicionar novos produtos com Nome, Preço, Quantidade e Categoria.
* **Edição:** Atualizar dados de produtos existentes.
* **Eliminação:** Remover produtos do sistema com confirmação de segurança.

### 📂 Gestão de Categorias
* **Organização:** Os produtos são organizados por categorias relacionais (One-to-Many).
* **Criação Rápida (Smart UX):** Possibilidade de criar uma nova categoria diretamente no formulário de criação de produto (Lógica Condicional), sem necessidade de mudar de página.
* **Backoffice de Categorias:** Painel dedicado para criar, editar e eliminar categorias.

### 📊 Inteligência de Negócio & Dashboard
* **Cálculo Automático:** O sistema calcula automaticamente o **Valor Total do Stock** (Preço × Quantidade) para cada produto e o total global do armazém.
* **Alertas de Stock:** Linhas da tabela mudam de cor (vermelho) e exibem um alerta "⚠️ Baixo!" quando a quantidade é inferior a 3 unidades.

### 🔍 Pesquisa e Filtros
* **Barra de Pesquisa:** Filtragem dinâmica de produtos pelo nome (Case Insensitive) através de Custom Queries no JPA.

---

## 🛠️ Tecnologias Utilizadas

**Backend:**
* **Java 17+**: Linguagem principal.
* **Spring Boot 3**: Framework para configuração e arranque rápido.
* **Spring Data JPA**: Para persistência de dados e abstração de SQL.
* **Hibernate**: ORM para mapeamento das entidades.
* **MySQL**: Base de dados relacional.

**Frontend:**
* **Thymeleaf**: Renderização de HTML no servidor (Server-side rendering).
* **Bootstrap 5**: Framework CSS para design responsivo e moderno.
* **HTML5 / CSS3**: Estrutura e estilo.

**Ferramentas:**
* **Maven**: Gestão de dependências.
* **IntelliJ IDEA**: IDE de desenvolvimento.
* **Git / GitHub**: Controlo de versões.

---

## 📸 Screenshots

<img width="1865" height="722" alt="image" src="https://github.com/user-attachments/assets/6a05ebb5-5f65-4e95-8d82-500836ea30b1" />
<img width="1835" height="657" alt="image" src="https://github.com/user-attachments/assets/05a3620a-0e4d-448d-affb-ef83347c9edd" />
<img width="1671" height="843" alt="image" src="https://github.com/user-attachments/assets/02ab1377-94d6-474e-85e6-0e2108418a54" />
<img width="1367" height="886" alt="image" src="https://github.com/user-attachments/assets/ac2295fa-024d-45d9-b2c2-ede9636e6667" />
<img width="1806" height="535" alt="image" src="https://github.com/user-attachments/assets/23972785-c93e-4c75-8b99-3e5d43e32e38" />
<img width="1174" height="434" alt="image" src="https://github.com/user-attachments/assets/4f9dca6b-150c-4505-b081-b42d6d432357" />







## 🚀 Como executar o projeto

### Pré-requisitos
* Java JDK 17 ou superior instalado.
* MySQL instalado e a correr.

### Passo a Passo

1.  **Clonar o repositório:**
    ```bash
    git clone [https://github.com/gbrito11/Stocks.git](https://github.com/gbrito11/Stocks.git)
    ```

2.  **Configurar a Base de Dados:**
    * Crie uma base de dados no MySQL chamada `loja_db`.
    * No ficheiro `src/main/resources/application.properties`, altere o username e password:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/loja_db
    spring.datasource.username=SEU_USER_MYSQL
  spring.datasource.password=SUA_SENHA_MYSQL
    ```

3.  **Executar a aplicação:**
    * Abra o projeto no IntelliJ (ou via terminal).
    * Execute a classe `AppComprasApplication`.

4.  **Aceder:**
    * Abra o navegador e vá a: `http://localhost:8080/loja`

---

## 👤 Autor

Desenvolvido por Guilherme de Brito Moreira.
