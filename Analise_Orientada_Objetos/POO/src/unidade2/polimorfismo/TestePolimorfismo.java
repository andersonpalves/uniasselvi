package unidade2.polimorfismo;

// Classe base genérica
class Animal {
    // Método genérico que será sobrescrito pelas subclasses
    public void emitirSom() {
        System.out.println("Som genérico de animal");
    }

    // Outro método comum para todos os animais
    public void dormir() {
        System.out.println("Zzz...");
    }
}

// Subclasse Cachorro
class Cachorro extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Au Au!");
    }

    public void abanarRabo() {
        System.out.println("Cachorro abanando o rabo");
    }
}

// Subclasse Gato
class Gato extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Miau!");
    }

    public void arranhar() {
        System.out.println("Gato arranhando o sofá");
    }
}

// Subclasse Vaca
class Vaca extends Animal {
    @Override
    public void emitirSom() {
        System.out.println("Muuu!");
    }
}

// Programa principal
public class TestePolimorfismo {
    public static void main(String[] args) {
        // Criamos um array de referência genérica Animal
        Animal[] animais = { new Cachorro(), new Gato(), new Vaca() };

        // Loop polimórfico: cada objeto responde de forma diferente
        for (Animal a : animais) {
            a.emitirSom();   // comportamento varia conforme o objeto real
            a.dormir();      // comportamento comum herdado da classe base
        }

        // Acesso a métodos específicos (precisa de cast)
        ((Cachorro) animais[0]).abanarRabo();
        ((Gato) animais[1]).arranhar();
    }
}

