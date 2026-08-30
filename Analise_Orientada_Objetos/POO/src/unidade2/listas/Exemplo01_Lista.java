package unidade2.listas;

import java.util.ArrayList;
import java.util.List;

public class Exemplo01_Lista {
    public static void main(String[] args) {
        List<String> alunos = new ArrayList<>();
        alunos.add("Maria");
        alunos.add("João");
        alunos.add("Ana");

        System.out.println("Alunos cadastrados:");
        for (String nome : alunos) {
            System.out.println(nome);
        }
    }
}

