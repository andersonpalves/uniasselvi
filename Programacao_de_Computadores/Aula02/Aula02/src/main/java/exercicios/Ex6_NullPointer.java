package exercicios;

class Ex6_NullPointer {
    static class Conta {
        double saldo = 100;
    }

    public static void main(String[] args) {
        try {
            Conta c = null;
            System.out.println(c.saldo);
        } catch (NullPointerException e) {
            System.out.println("Objeto não instanciado!");
        }
    }
}