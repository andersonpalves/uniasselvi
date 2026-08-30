package unidade2.pdv;

import unidade2.pdv.modelos.Pagamento;
import unidade2.pdv.modelos.Produto;
import unidade2.pdv.modelos.Recibo;

public class Caixa {
    public void processarVenda(Cliente cliente, Produto produto) {
        System.out.println("Cliente " + cliente.getNome() + " comprou " + produto.getNome());

        Pagamento pagamento = new Pagamento();
        pagamento.realizarPagamento(produto.getPreco());

        Recibo recibo = new Recibo();
        recibo.gerarRecibo(cliente, produto.getPreco());
    }
}
