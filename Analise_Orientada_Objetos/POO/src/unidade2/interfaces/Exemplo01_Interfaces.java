package unidade2.interfaces;

// Definição da interface
interface Veiculo {
    void acelerar();   // contrato: toda classe deve implementar
    void frear();      // contrato: toda classe deve implementar
}

// Classe Carro implementa a interface
class Carro implements Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Carro acelerando com motor a combustão!");
    }

    @Override
    public void frear() {
        System.out.println("Carro freando com sistema ABS!");
    }
}

// Classe Bicicleta implementa a interface
class Bicicleta implements Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Bicicleta acelerando com pedaladas!");
    }

    @Override
    public void frear() {
        System.out.println("Bicicleta freando com os freios manuais!");
    }
}

// Programa principal
public class Exemplo01_Interfaces {
    public static void main(String[] args) {
        // Podemos usar a referência genérica Veiculo
        Veiculo v1 = new Carro();
        Veiculo v2 = new Bicicleta();

        // Chamadas polimórficas: mesmo método, comportamentos diferentes
        v1.acelerar();
        v1.frear();

        v2.acelerar();
        v2.frear();
    }
}
