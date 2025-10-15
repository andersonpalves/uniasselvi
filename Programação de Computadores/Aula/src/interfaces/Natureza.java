package interfaces;

// Interface 1: comportamento de voar
interface Voador {
    void voar();
}

// Interface 2: comportamento de nadar
interface Nadador {
    void nadar();
}

// Classe concreta que herda múltiplos comportamentos
class Pato implements Voador, Nadador {
    public void voar() {
        System.out.println("O pato está voando!");
    }

    public void nadar() {
        System.out.println("O pato está nadando!");
    }
}

// Classe principal para testar
public class Natureza {
    public static void main(String[] args) {
        Pato pato = new Pato();
        pato.voar();
        pato.nadar();
    }
}
