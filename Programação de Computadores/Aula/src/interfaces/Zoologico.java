package interfaces;

// Interface que define o comportamento comum
interface Animal {
    void emitirSom();
    void mover();
}

// Classe abstrata que implementa parte do comportamento
abstract class Mamifero implements Animal {
    public void mover() {
        System.out.println("O mamífero está se movendo...");
    }

    // Método abstrato que será implementado pelas subclasses
    public abstract void emitirSom();
}

// Classe concreta: Cachorro
class Cachorro extends Mamifero {

    @Override
    public void emitirSom() {
        System.out.println("O cachorro late: Au au!");
    }
}

// Classe concreta: Gato
class Gato extends Mamifero {
    public void emitirSom() {
        System.out.println("O gato mia: Miau!");
    }
}

class Coelho implements Animal{

    @Override
    public void emitirSom() {

    }

    @Override
    public void mover() {

    }
}

// Classe principal para testar
public class Zoologico {
    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();
        Animal a3 = new Coelho();

        a1.emitirSom();
        a1.mover();

        a2.emitirSom();
        a2.mover();

        a3.emitirSom();
        a3.mover();
    }
}
