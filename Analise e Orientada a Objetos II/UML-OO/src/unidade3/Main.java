package unidade3;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Deletar Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço: ");
                    Double preco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Tipo: ");
                    String tipo = scanner.nextLine();

                    Produto produto = service.criar(nome, preco, tipo);
                    System.out.println("Produto cadastrado: " + produto);
                    break;

                case 2:
                    List<Produto> produtos = service.listar();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        produtos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("ID do produto: ");
                    Long idAtualizar = scanner.nextLong();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Novo preço: ");
                    Double novoPreco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Novo tipo: ");
                    String novoTipo = scanner.nextLine();

                    boolean atualizado = service.atualizar(idAtualizar, novoNome, novoPreco, novoTipo);

                    if (atualizado) {
                        System.out.println("Produto atualizado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("ID do produto: ");
                    Long idDeletar = scanner.nextLong();

                    boolean deletado = service.deletar(idDeletar);

                    if (deletado) {
                        System.out.println("Produto removido!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 5:
                    System.out.println("Encerrando sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}