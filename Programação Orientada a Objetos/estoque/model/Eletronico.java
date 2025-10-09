package estoque.model;

public class Eletronico extends Produto {
    private String marca;

    public Eletronico(int id, String nome, double preco, int quantidade, String marca) {
        super(id, nome, preco, quantidade);
        this.marca = marca;
    }

    @Override
    public String getTipo() {
        return "Eletrônico";
    }

    @Override
    public String toString() {
        return super.toString() + " | Marca: " + marca;
    }
}

