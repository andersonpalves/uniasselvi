package unidade1;

class Animal {
    void emitirSom() {
        System.out.println("Som genérico...");
    }
}

class Cachorro extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Latido!");
    }
}

class Gato extends Animal {
    @Override
    void emitirSom() {
        System.out.println("Miau!");
    }
}

public class Exemplo03_Animal {
    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();
        a1.emitirSom();
        a2.emitirSom();
    }
}
