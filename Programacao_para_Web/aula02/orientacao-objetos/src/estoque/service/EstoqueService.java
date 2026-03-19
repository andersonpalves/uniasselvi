package estoque.service;

import estoque.model.Gerenciavel;
import estoque.repository.EstoqueRepository;

import java.util.*;

public class EstoqueService implements EstoqueRepository {
    private Map<Integer, Gerenciavel> itens = new HashMap<>();
    private int proximoId = 1;

    @Override
    public void adicionar(Gerenciavel item) {
        itens.put(item.getId(), item);
    }

    @Override
    public List<Gerenciavel> listar() {
        return new ArrayList<>(itens.values());
    }

    @Override
    public Gerenciavel buscarPorId(int id) {
        return itens.get(id);
    }

    @Override
    public boolean remover(int id) {
        return itens.remove(id) != null;
    }

    @Override
    public void atualizarQuantidade(int id, int novaQtd) {
        Gerenciavel item = itens.get(id);
        if (item != null) {
            item.setQuantidade(novaQtd);
        }
    }

    @Override
    public int gerarId() {
        return proximoId++;
    }
}

