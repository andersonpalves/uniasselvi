package exemplo;

// Classe base abstrata
abstract class Animal {
    public abstract void emitirSom();
}

// Subclasse Cachorro
class Cachorro extends Animal {
    public void emitirSom() {
        System.out.println("Au au");
    }
}

// Subclasse Gato
class Gato extends Animal {
    public void emitirSom() {
        System.out.println("Miau");
    }
}

// Classe principal
public class TestePolimorfismo {
    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();

        a1.emitirSom(); // Saída: Au au
        a2.emitirSom(); // Saída: Miau
    }
}
