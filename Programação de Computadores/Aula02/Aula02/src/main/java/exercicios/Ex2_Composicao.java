class Ex2_Composicao {
    static class Cliente {
        String nome;
        Cliente(String nome){ this.nome = nome; }
    }

    static class Conta {
        Cliente cliente;
        Conta(Cliente c){ this.cliente = c; }
    }

    public static void main(String[] args) {
        Cliente c = new Cliente("Maria");
        Conta conta = new Conta(c);
        System.out.println(conta.cliente.nome);
    }
}