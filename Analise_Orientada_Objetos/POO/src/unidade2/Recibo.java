package unidade2;

public class Recibo {
    public void gerarRecibo(Cliente cliente, double valor) {
        System.out.println("Recibo gerado para " + cliente.getNome() + " no valor de R$ " + valor);
    }
}
