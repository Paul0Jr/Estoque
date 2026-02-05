# 📦 Estoque — Sistema Desktop de Gestão de Estoque

Sistema completo de gerenciamento de estoque desenvolvido em Java com interface gráfica (Swing) e persistência em MySQL. Ideal para pequenos e médios negócios que precisam controlar produtos, fornecedores, compras e vendas.

## 🎯 Funcionalidades Principais

### Autenticação e Controle de Acesso
- **Login de Usuários** — autenticação via email/senha contra banco de dados
- **Cadastro de Usuários** — interface para novos usuários se registrarem
- **Menu Principal** — dashboard com navegação para módulos

### Gerenciamento de Produtos
- Listar todos os produtos em tabela
- Buscar produtos por **ID** ou **Nome**
- **Adicionar** produtos (ID, nome, quantidade, preço)
- **Atualizar** informações de produto
- **Deletar** produtos do estoque
- Campos: ID, Nome, Quantidade, Preço

### Gerenciamento de Fornecedores
- Listar fornecedores cadastrados
- Buscar fornecedor por **ID** ou **Nome**
- **Adicionar** fornecedor (ID, nome, número de contato)
- **Atualizar** dados de fornecedor
- **Deletar** fornecedor do banco
- Campos: ID, Nome, Número

### Histórico de Compras
- Registrar compra de produtos
- Atualizar automaticamente a quantidade em estoque
- Buscar histórico de compra por ID do produto
- Exibir cálculo de gasto total (preço × quantidade)
- Tabela com: ID Produto, Quantidade, Preço da Compra, Gasto

### Histórico de Vendas
- Registrar venda de produtos
- Reduzir automaticamente a quantidade em estoque
- Buscar histórico de venda por ID do produto
- Exibir cálculo de receita total (preço × quantidade)
- Tabela com: ID Produto, Quantidade, Preço de Venda, Receita

---

## 🛠️ Stack Técnico

| Componente | Versão/Tecnologia |
|---|---|
| **Linguagem** | Java 8+ |
| **GUI** | Swing (NetBeans GUI Builder) |
| **Banco de Dados** | MySQL 5.7+ |
| **Driver JDBC** | mysql-connector-j 8.1.0 |
| **Build Tool** | Apache Ant |
| **IDE** | NetBeans (recomendado para editar formulários) |

---

## 📁 Estrutura do Projeto

```
src/
├── JPanels/
│   ├── Compras.java
│   ├── Fornecedores.java
│   ├── Produtos.java
│   └── Vendas.java
├── view/
│   └── TelaLogin.java
├── controller/
│   └── EstoqueController.java
├── model/
│   ├── Compra.java
│   ├── Fornecedor.java
│   ├── Produto.java
│   └── Venda.java
├── persistence/
│   └── EstoqueDAO.java
└── Estoque.java
```

---

## 📋 Requisitos

- **Java Runtime Environment (JRE)** 8 ou superior
- **MySQL Server** 5.7+ (ou MariaDB compatível)
- **Mínimo 256 MB** de memória disponível
- NetBeans (opcional, apenas para editar/recompilare fontes `.form`)

---

## 🗄️ Configuração do Banco de Dados

### Credenciais Padrão
As credenciais padrão configuradas no código são:
- **Host**: `127.0.0.1` (localhost)
- **Porta**: `3306`
- **Database**: `estoque`
- **Usuário**: `root`
- **Senha**: `` (vazia)

### Alterar Credenciais
Se seu MySQL tiver credenciais diferentes, edite os seguintes arquivos:
- [src/JPanels/Produtos.java](src/JPanels/Produtos.java#L115) — linhas com `BDurl`, `BDusuario`, `BDsenha`
- [src/JPanels/Fornecedores.java](src/JPanels/Fornecedores.java#L22)
- [src/JPanels/Compras.java](src/JPanels/Compras.java#L25)
- [src/JPanels/Vendas.java](src/JPanels/Vendas.java#L25)
- [src/view/TelaLogin.java](src/view/TelaLogin.java#L240)

---

## 🗄️ Schema SQL

Execute os comandos abaixo no MySQL para criar a estrutura do banco:

```sql
-- Criar banco de dados
CREATE DATABASE IF NOT EXISTS estoque 
  DEFAULT CHARSET=utf8mb4 
  COLLATE=utf8mb4_general_ci;

USE estoque;

-- Tabela de Produtos
CREATE TABLE produtos (
  id INT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  quantidade INT DEFAULT 0,
  `preço` DECIMAL(10,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Fornecedores
CREATE TABLE fornecedores (
  id INT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  numero VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Compras
CREATE TABLE compras (
  idcompra INT AUTO_INCREMENT PRIMARY KEY,
  idprod INT NOT NULL,
  quantidade INT,
  `preço` DECIMAL(10,2),
  gasto DECIMAL(12,2),
  FOREIGN KEY (idprod) REFERENCES produtos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Vendas
CREATE TABLE vendas (
  idvenda INT AUTO_INCREMENT PRIMARY KEY,
  idprod INT NOT NULL,
  quantidade INT,
  `preço` DECIMAL(10,2),
  receita DECIMAL(12,2),
  FOREIGN KEY (idprod) REFERENCES produtos(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Tabela de Login/Cadastro
CREATE TABLE login_cadastro (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome_comp VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  senha VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- (Opcional) Inserir usuário de teste
INSERT INTO login_cadastro (nome_comp, email, senha) 
VALUES ('Admin', 'admin@estoque.com', '123456');
```
