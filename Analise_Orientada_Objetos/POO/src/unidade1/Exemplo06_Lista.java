package unidade1;

import java.util.ArrayList;
import java.util.List;

public class Exemplo06_Lista {
    public static void main(String[] args) {
        List<String> alunos = new ArrayList<>();
        alunos.add("Maria");
        alunos.add("João");
        alunos.add("Ana");
        alunos.add("Carlos");
        alunos.add("Fernanda");

        System.out.println("Lista de alunos: " + alunos);

        alunos.remove("Carlos");
        System.out.println("Após remoção: " + alunos);

        System.out.println("Contém Ana? " + alunos.contains("Ana"));
    }
}
