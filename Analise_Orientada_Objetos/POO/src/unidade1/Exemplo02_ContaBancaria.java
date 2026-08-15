package unidade1;

import unidade1.modelos.ContaBancaria;

public class Exemplo02_ContaBancaria {

    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(500);
        System.out.println("Saldo atual: " + conta.getSaldo());
    }
}
