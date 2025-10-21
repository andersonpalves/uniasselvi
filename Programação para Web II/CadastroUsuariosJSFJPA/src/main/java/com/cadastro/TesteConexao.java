package com.cadastro;

import java.util.List;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Iniciando teste de conexão JPA/MySQL...");

        UsuarioDAO dao = new UsuarioDAO();

        // cria usuário de teste
        Usuario u = new Usuario("Teste JPA", "teste.jpa@example.com");
        try {
            Usuario salvo = dao.salvar(u);
            System.out.println("Usuário salvo: " + salvo);

            List<Usuario> todos = dao.listar();
            System.out.println("Lista de usuários no banco:");
            for (Usuario uu : todos) {
                System.out.println("  " + uu);
            }

            System.out.println("Teste finalizado com sucesso.");
        } catch (Exception e) {
            System.err.println("Erro durante teste JPA: ");
            e.printStackTrace();
        }
    }
}
