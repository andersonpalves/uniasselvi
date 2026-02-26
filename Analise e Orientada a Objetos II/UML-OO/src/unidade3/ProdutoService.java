package unidade3;

import java.util.List;
import java.util.Optional;

public class ProdutoService {

    private final ProdutoRepository repository;
    private Long contadorId = 1L;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Produto criar(String nome, Double preco, String tipo) {
        Produto produto = new Produto(contadorId++, nome, preco, tipo);
        repository.salvar(produto);
        return produto;
    }

    public List<Produto> listar() {
        return repository.listar();
    }

    public boolean atualizar(Long id, String nome, Double preco, String tipo) {
        Optional<Produto> produtoOpt = repository.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setTipo(tipo);
            return true;
        }
        return false;
    }

    public boolean deletar(Long id) {
        Optional<Produto> produtoOpt = repository.buscarPorId(id);

        if (produtoOpt.isPresent()) {
            repository.deletar(id);
            return true;
        }
        return false;
    }
}
