package unidade1;

import java.util.HashSet;
import java.util.Set;

public class Exemplo07_Set {
    public static void main(String[] args) {
        Set<Integer> numeros = new HashSet<>();
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(20); // repetido

        System.out.println("Conjunto de números: " + numeros);

        System.out.println("Contém 30? " + numeros.contains(30));

        numeros.remove(10);
        System.out.println("Após remoção: " + numeros);
    }
}
