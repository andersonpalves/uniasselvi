package unidade2.pdv.modelos;

import unidade2.pdv.Cliente;

public class Recibo {
    public void gerarRecibo(Cliente cliente, double valor) {
        System.out.println("Recibo gerado para " + cliente.getNome() + " no valor de R$ " + valor);
    }
}
