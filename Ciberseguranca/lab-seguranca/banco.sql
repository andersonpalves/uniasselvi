CREATE DATABASE lab_seguranca;

USE lab_seguranca;

CREATE TABLE usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100),
    senha VARCHAR(255)
);

CREATE TABLE comentarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT
);

INSERT INTO usuarios (email, senha) VALUES
('admin@email.com', '123456'),
('user@email.com', 'senha123');