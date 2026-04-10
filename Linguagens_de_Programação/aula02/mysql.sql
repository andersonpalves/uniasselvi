-- MYSQL

-- 1 INTRODUÇÃO
-- MySQL é um SGBD relacional que armazena dados em tabelas
-- Utiliza SQL (Structured Query Language) para operações

-- 2 HISTÓRIA DO MYSQL
-- Criado nos anos 90 pela empresa MySQL AB
-- Atualmente pertence à Oracle
-- Muito utilizado junto com PHP no desenvolvimento web


-- 3 SQL: INSTRUÇÕES DDL E DML

-- =========================
-- DDL (Data Definition Language)
-- =========================

-- Cria um banco de dados chamado "exemplo_php_mysql"
CREATE DATABASE exemplo_php_mysql;

-- Seleciona o banco para uso
USE exemplo_php_mysql;

-- Cria uma tabela chamada "usuarios"
-- id: identificador único com auto incremento
-- nome: texto com até 100 caracteres
-- email: texto com até 100 caracteres
-- idade: número inteiro
CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    idade INT
);

-- =========================
-- DML (Data Manipulation Language)
-- =========================

-- Insere múltiplos registros na tabela usuarios
-- Cada linha representa um usuário
INSERT INTO usuarios (nome, email, idade) VALUES
('Anderson', 'anderson@email.com', 30),
('Maria', 'maria@email.com', 25);


-- 4 PHPMYADMIN
-- Interface gráfica para gerenciar bancos MySQL
-- Permite executar comandos SQL sem usar terminal
-- Muito usado em ambientes locais (XAMPP, WAMP, etc)


-- 5 CRIANDO OBJETOS DE BANCO

-- Cria uma nova tabela chamada "produtos"
-- preco usa DECIMAL para valores monetários
CREATE TABLE produtos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    preco DECIMAL(10,2)
);

-- Cria um índice na coluna "nome" da tabela usuarios
-- Isso melhora a performance de buscas por nome
CREATE INDEX idx_nome_usuario ON usuarios(nome);

-- Cria uma VIEW (visão virtual)
-- Mostra apenas usuários maiores de idade
CREATE VIEW vw_usuarios_maiores AS
SELECT nome, idade 
FROM usuarios 
WHERE idade >= 18;


-- 6 MANIPULANDO OS DADOS COM DML

-- Seleciona todos os registros da tabela usuarios
SELECT * FROM usuarios;

-- Seleciona usuários com idade maior que 25
SELECT * 
FROM usuarios 
WHERE idade > 25;

-- Atualiza a idade de um usuário específico
-- Altera idade para 31 onde o nome for 'Anderson'
UPDATE usuarios
SET idade = 31
WHERE nome = 'Anderson';

-- Remove registros da tabela usuarios
-- Exclui usuários com nome 'Maria'
DELETE FROM usuarios
WHERE nome = 'Maria';

-- Insere um novo produto na tabela produtos
INSERT INTO produtos (nome, preco) 
VALUES ('Notebook', 3500.00);

-- Realiza um JOIN entre usuarios e produtos
-- Relaciona dados das duas tabelas
-- OBS: aqui usamos id=id apenas para exemplo didático
SELECT u.nome, p.nome AS produto
FROM usuarios u
JOIN produtos p ON u.id = p.id;

-- Ordena os usuários pelo nome em ordem crescente (ASC)
SELECT * 
FROM usuarios 
ORDER BY nome ASC;

-- Limita o resultado a apenas 2 registros
SELECT * 
FROM usuarios 
LIMIT 2;