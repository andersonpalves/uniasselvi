package estoque.repository;
import estoque.model.Gerenciavel;

import java.util.*;

public interface EstoqueRepository {
    void adicionar(Gerenciavel item);
    List<Gerenciavel> listar();
    Gerenciavel buscarPorId(int id);
    boolean remover(int id);
    void atualizarQuantidade(int id, int novaQtd);
    int gerarId();
}

