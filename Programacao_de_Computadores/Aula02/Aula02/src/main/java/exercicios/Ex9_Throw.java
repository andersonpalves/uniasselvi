package exercicios;

class Ex9_Throw {
    static class Conta {
        void sacar(double v){
            if(v < 0){
                throw new IllegalArgumentException("Valor inválido");
            }
        }
    }

    public static void main(String[] args) {
        Conta c = new Conta();
        c.sacar(-10);
    }
}