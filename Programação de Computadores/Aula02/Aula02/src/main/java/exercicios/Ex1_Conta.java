class Ex1_Conta {
    static class Conta {
        private String titular;
        private double saldo;

        public Conta(String titular) {
            this.titular = titular;
            this.saldo = 0;
        }

        public void depositar(double valor) {
            saldo += valor;
        }

        public void sacar(double valor) {
            if (valor <= saldo) {
                saldo -= valor;
            } else {
                System.out.println("Saldo insuficiente");
            }
        }

        public double getSaldo() {
            return saldo;
        }
    }

    public static void main(String[] args) {
        Conta conta = new Conta("João");
        conta.depositar(1000);
        conta.sacar(200);
        System.out.println(conta.getSaldo());
    }
}