package unidade2.listas;

import java.util.HashMap;
import java.util.Map;

public class Exemplo03_Map {
    public static void main(String[] args) {
        Map<String, Double> notas = new HashMap<>();
        notas.put("Maria", 8.5);
        notas.put("João", 7.0);
        notas.put("Ana", 9.2);

        System.out.println("Notas dos alunos:");
        for (String aluno : notas.keySet()) {
            System.out.println(aluno + " -> " + notas.get(aluno));
        }
    }
}
