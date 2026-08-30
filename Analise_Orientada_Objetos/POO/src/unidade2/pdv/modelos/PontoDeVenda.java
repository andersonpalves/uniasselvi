package unidade2.pdv.modelos;

import unidade2.pdv.Caixa;
import unidade2.pdv.Cliente;

public class PontoDeVenda {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Ânderson");
        Produto produto = new Produto("Notebook", 3500.00);

        Caixa caixa = new Caixa();
        caixa.processarVenda(cliente, produto);
    }
}

