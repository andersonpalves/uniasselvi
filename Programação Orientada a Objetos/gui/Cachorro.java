package gui;

public class Cachorro extends Animal {
    public Cachorro(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Au au!";
    }
}
