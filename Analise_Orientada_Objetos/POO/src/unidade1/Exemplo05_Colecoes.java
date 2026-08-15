package unidade1;
import java.util.*;

public class Exemplo05_Colecoes {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();
        alunos.add("Maria");
        alunos.add("João");
        alunos.add("Maria"); // duplicado

        System.out.println("Lista de alunos:");
        for (String aluno : alunos) {
            System.out.println(aluno);
        }

        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "Primeiro");
        mapa.put(2, "Segundo");

        System.out.println("\nValor da chave 1: " + mapa.get(1));
    }
}
