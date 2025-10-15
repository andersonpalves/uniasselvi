package estoque.model;

public class Bebida extends Produto {

    private String tipoBebida;

    public Bebida(int id, String nome, double preco, int quantidade, String tipoBebida) {
        super(id, nome, preco, quantidade);
        this.tipoBebida = tipoBebida;
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }

    public String getTipoBebida() {
        return tipoBebida;
    }
}
