package unidade2.listas;

import java.util.HashSet;
import java.util.Set;

public class Exemplo02_Set {
    public static void main(String[] args) {
        Set<String> cursos = new HashSet<>();
        cursos.add("Java");
        cursos.add("Python");
        cursos.add("Java"); // duplicado, será ignorado

        System.out.println("Cursos disponíveis:");
        for (String curso : cursos) {
            System.out.println(curso);
        }
    }
}
