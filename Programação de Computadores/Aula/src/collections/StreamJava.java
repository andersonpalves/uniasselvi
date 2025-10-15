package collections;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJava {

    public static void main(String[] args) {
        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        for (int i=0; i<listaNumeros.size(); i++) {
            if (listaNumeros.get(i) % 2 == 0) {
                System.out.println("o numero " + listaNumeros.get(i) + " é par");
            }
        }

    //------------------------------------------------------------------------------//

        List<Integer> listaNumerosResp = listaNumeros.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(listaNumerosResp);
    }
}
