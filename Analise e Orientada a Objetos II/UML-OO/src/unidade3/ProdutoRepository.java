package unidade3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoRepository {

    private List<Produto> banco = new ArrayList<>();

    public void salvar(Produto produto) {
        banco.add(produto);
    }

    public List<Produto> listar() {
        return banco;
    }

    public Optional<Produto> buscarPorId(Long id) {
        return banco.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deletar(Long id) {
        banco.removeIf(p -> p.getId().equals(id));
    }
}
