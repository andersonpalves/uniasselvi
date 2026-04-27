import java.util.*;
class Ex7_MultiplosCatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] v = {10,20,30};

        try {
            int i = sc.nextInt();
            System.out.println(v[i]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Índice inválido");
        } catch (Exception e) {
            System.out.println("Erro geral");
        }
    }
}