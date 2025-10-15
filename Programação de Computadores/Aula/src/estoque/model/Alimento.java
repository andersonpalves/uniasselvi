package estoque.model;

public class Alimento extends Produto {

    private String validade;

    public Alimento(int id, String nome, double preco, int quantidade, String validade) {
        super(id, nome, preco, quantidade);
        this.validade = validade;
    }

    @Override
    public String getTipo() {
        return "Alimento";
    }

    @Override
    public String toString() {
        return super.toString() + " | Validade: " + validade;
    }
}
