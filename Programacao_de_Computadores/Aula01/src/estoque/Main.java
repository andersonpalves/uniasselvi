package estoque;

import estoque.model.Alimento;
import estoque.model.Bebida;
import estoque.model.Eletronico;
import estoque.model.Gerenciavel;
import estoque.service.EstoqueService;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EstoqueService service = new EstoqueService();
        int opcao;

        do {
            System.out.println("\n=== MENU ESTOQUE ===");
            System.out.println("1. Adicionar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Buscar produto por ID");
            System.out.println("4. Remover produto");
            System.out.println("5. Atualizar quantidade");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> adicionarProduto(sc, service);
                case 2 -> listar(service);
                case 3 -> buscar(sc, service);
                case 4 -> remover(sc, service);
                case 5 -> atualizar(sc, service);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void adicionarProduto(Scanner sc, EstoqueService service) {
        System.out.println("Tipo (1-Alimento | 2-Eletrônico | 3-Bebida)");
        int tipo = sc.nextInt(); sc.nextLine();

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        System.out.print("Quantidade: ");
        int qtd = sc.nextInt(); sc.nextLine();

        int id = service.gerarId();

        Gerenciavel p = null;
        if (tipo == 1) {
            System.out.print("Validade: ");
            String validade = sc.nextLine();
            p = new Alimento(id, nome, preco, qtd, validade);
        } else if (tipo == 2) {
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            p = new Eletronico(id, nome, preco, qtd, marca);
        } else if (tipo == 3) {
            System.out.print("Tipo de bebida: ");
            String tipoBebida = sc.nextLine();
            p = new Bebida(id, nome, preco, qtd, tipoBebida);
        } else {
            System.out.println("Tipo inválido!");
            return;
        }

        service.adicionar(p);
        System.out.println("Produto adicionado: " + p);
    }

    private static void listar(EstoqueService service) {
        List<Gerenciavel> lista = service.listar();
        if (lista.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            lista.forEach(System.out::println);
        }
    }

    private static void buscar(Scanner sc, EstoqueService service) {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        Gerenciavel p = service.buscarPorId(id);
        System.out.println(p != null ? p : "Produto não encontrado!");
    }

    private static void remover(Scanner sc, EstoqueService service) {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        boolean ok = service.remover(id);
        System.out.println(ok ? "Produto removido." : "Produto não encontrado.");
    }

    private static void atualizar(Scanner sc, EstoqueService service) {
        System.out.print("ID do produto: ");
        int id = sc.nextInt();
        System.out.print("Nova quantidade: ");
        int qtd = sc.nextInt();

        Gerenciavel p = service.buscarPorId(id);
        if (p != null) {
            service.atualizarQuantidade(id, qtd);
            System.out.println("Quantidade atualizada: " + p);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}

