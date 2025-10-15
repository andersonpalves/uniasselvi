package exemplo;

public class Erro {

    public static void main(String[] args) {

//        try {
//            throw new Exception("Erro");
//        } catch (ArithmeticException e){
//            System.out.println("Erro de divisão");
//        } catch (Exception e) {
//            System.out.println("Erro forçado!!!");
//        } finally {
//            System.out.println("Fim do processo");
//        }

        int[] numeros = new int[5];
        numeros[0] = 10;
        numeros[1] = 20;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }


        int[][] matriz = new int[2][3];
        matriz[0][1] = 5;
    }
}
