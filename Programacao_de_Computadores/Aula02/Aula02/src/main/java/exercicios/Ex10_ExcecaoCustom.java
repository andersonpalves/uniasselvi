package exercicios;

class Ex10_ExcecaoCustom {
    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String msg){ super(msg); }
    }

    static class Conta {
        double saldo = 100;

        void sacar(double v) throws SaldoInsuficienteException {
            if(v > saldo){
                throw new SaldoInsuficienteException("Saldo insuficiente");
            }
        }
    }

    public static void main(String[] args) {
        Conta c = new Conta();
        try {
            c.sacar(200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}