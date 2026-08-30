package unidade3;

public class ExemploSingleton {

    // Instância única da classe (lazy initialization)
    // static par que possa chamá-lo sem precisar criar um objeto da classe.
    // Isso é essencial, já que o construtor é privado e não pode ser usado diretamente.
    private static ExemploSingleton instancia;

    // Construtor privado para evitar criação externa
    private ExemploSingleton() {
        System.out.println("Instância criada!");
    }

    // Método público para obter a instância única
    public static ExemploSingleton getInstancia() {
        if (instancia == null) {
            instancia = new ExemploSingleton();
        }
        return instancia;
    }

    // Método de exemplo
    public void mostrarMensagem() {
        System.out.println("Olá! Eu sou um Singleton.");
    }

    // Método main para testar
    public static void main(String[] args) {
        ExemploSingleton obj1 = ExemploSingleton.getInstancia();
        obj1.mostrarMensagem();

        ExemploSingleton obj2 = ExemploSingleton.getInstancia();
        obj2.mostrarMensagem();

        // Verificando se é a mesma instância
        System.out.println("São a mesma instância? " + (obj1 == obj2));
    }
}
