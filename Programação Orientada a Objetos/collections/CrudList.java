package collections;

import java.util.*;

public class CrudList {
    public static void main(String[] args) {
        List<String> listaDeNomes = new ArrayList<>();

        // Create
        listaDeNomes.add("Ana");
        listaDeNomes.add("Bruno");

        // Read
        System.out.println("Lista: " + listaDeNomes);

        // Update
        listaDeNomes.set(1, "Beatriz"); // altera Bruno para Beatriz

        // Delete
        listaDeNomes.remove("Ana");

        System.out.println("Após alterações: " + listaDeNomes);
    }
}
