package collections;

import java.util.*;

public class CrudQueue {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();

        // Create
        fila.offer("Cliente 1");
        fila.offer("Cliente 2");
        fila.offer("Cliente 2"); //remove só um elemento

        // Read
        System.out.println("Fila: " + fila);

        // Update (não direto — simula com remoção e reinserção)
        fila.poll(); // remove o primeiro
        fila.offer("Cliente 3");

        // Delete
        fila.remove("Cliente 2");

        System.out.println("Após alterações: " + fila);
    }
}
