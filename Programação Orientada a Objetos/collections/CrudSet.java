package collections;

import java.util.*;

public class CrudSet {
    public static void main(String[] args) {
        Set<String> listaDeFrutas = new HashSet<>();

        // Create
        listaDeFrutas.add("Maçã");
        listaDeFrutas.add("Banana");
        listaDeFrutas.add("Banana");
        listaDeFrutas.add("Banana");

        // Read
        System.out.println("Frutas: " + listaDeFrutas);

        // Update (não há índice, então remove e adiciona)
        listaDeFrutas.remove("Banana");
        listaDeFrutas.add("Manga");

        // Delete
        listaDeFrutas.remove("Maçã");

        System.out.println("Após alterações: " + listaDeFrutas);
    }
}
