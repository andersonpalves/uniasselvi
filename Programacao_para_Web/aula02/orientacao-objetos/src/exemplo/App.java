package exemplo;

public class App {

    public static void main(String[] args) {
        int[] numeros = new int[5];
        numeros[0] = 10;

        boolean leitura = true;
        int indice = 0;
        while (leitura) {
            System.out.println(numeros[indice]);
            indice++;
            if (indice == numeros.length) {
                leitura = false;
                System.out.println("Saindo meu while");
            }
        }
    }
}
