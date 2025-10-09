package collections;

import java.util.*;

public class CrudMap {
    public static void main(String[] args) {
        Map<Integer, String> listaDeUsuarios = new HashMap<>();

        // Create
        listaDeUsuarios.put(1, "Carlos");
        listaDeUsuarios.put(2, "Diana");

        // Read
        System.out.println("Usuários: " + listaDeUsuarios);

        // Update
        listaDeUsuarios.put(3, "Daniela"); // altera valor da chave 2
        listaDeUsuarios.put(10, "Daniela");

        // Delete
        listaDeUsuarios.remove(1);

        System.out.println("Após alterações: " + listaDeUsuarios);
    }
}
