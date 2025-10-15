package estoque.model;

public interface Gerenciavel {
    int getId();
    String getNome();
    double getPreco();
    int getQuantidade();
    void setQuantidade(int quantidade);
    String getTipo();
}
