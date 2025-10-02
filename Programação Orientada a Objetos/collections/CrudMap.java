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
        listaDeUsuarios.put(2, "Daniela"); // altera valor da chave 2

        // Delete
        listaDeUsuarios.remove(1);

        System.out.println("Após alterações: " + listaDeUsuarios);
    }
}
