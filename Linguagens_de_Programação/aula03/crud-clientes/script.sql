CREATE DATABASE IF NOT EXISTS clientes_db;
USE clientes_db;

CREATE TABLE clientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    cidade VARCHAR(50),
    estado VARCHAR(2)
);

INSERT INTO clientes (nome, email, telefone, cidade, estado)
VALUES ('João Silva', 'joao@email.com', '(51) 99999-1234', 'Porto Alegre', 'RS');

UPDATE clientes
SET nome = 'João Pedro Silva',
    email = 'joaopedro@email.com',
    telefone = '(51) 66666-4321',
    cidade = 'Gravataí',
    estado = 'RS'
WHERE id = 1;

DELETE FROM clientes
WHERE id = 1;

CREATE TABLE enderecos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT NOT NULL,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);

INSERT INTO enderecos (
    cliente_id,
    rua,
    numero,
    bairro,
    cep,
    cidade,
    estado
) VALUES (
    1, -- ID do cliente existente
    'Rua das Flores',
    '123',
    'Centro',
    '95000-000',
    'Gravataí',
    'RS'
);

