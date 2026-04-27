class Ex4_Polimorfismo {
    static class Animal {
        void emitirSom(){ System.out.println("Som genérico"); }
    }

    static class Cachorro extends Animal {
        void emitirSom(){ System.out.println("Latido"); }
    }

    static class Gato extends Animal {
        void emitirSom(){ System.out.println("Miau"); }
    }

    public static void main(String[] args) {
        Animal a1 = new Cachorro();
        Animal a2 = new Gato();
        a1.emitirSom();
        a2.emitirSom();
    }
}