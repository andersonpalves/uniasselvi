package org.example;

public class ComplexidadeAlgoritmica {

    // O(1) - Constante
    public static void exemploConstante() {
        int[] numeros = {10, 20, 30};
        System.out.println(numeros[1]);
    }

    // O(log n) - Logarítmica
    public static int buscaBinaria(int[] arr, int alvo) {
        int inicio = 0, fim = arr.length - 1;
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (arr[meio] == alvo) return meio;
            else if (arr[meio] < alvo) inicio = meio + 1;
            else fim = meio - 1;
        }
        return -1;
    }

    // O(n) - Linear
    public static void exemploLinear() {
        int[] numeros = {1, 2, 3, 4};
        for (int n : numeros) {
            System.out.println(n);
        }
    }

    // O(n log n) - Linearítmica (Merge Sort)
    public static void mergeSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(arr, inicio, meio);
            mergeSort(arr, meio + 1, fim);
            merge(arr, inicio, meio, fim);
        }
    }

    public static void merge(int[] arr, int inicio, int meio, int fim) {
        int[] temp = new int[fim - inicio + 1];
        int i = inicio, j = meio + 1, k = 0;

        while (i <= meio && j <= fim) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }

        while (i <= meio) temp[k++] = arr[i++];
        while (j <= fim) temp[k++] = arr[j++];

        for (i = 0; i < temp.length; i++) {
            arr[inicio + i] = temp[i];
        }
    }

    // O(n²) - Quadrática
    public static void exemploQuadratico() {
        int[] arr = {3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.println(arr[i] + arr[j]);
            }
        }
    }

    // O(n³) - Cúbica
    public static void exemploCubico() {
        int[] arr = {1, 2, 3};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    System.out.println(arr[i] + arr[j] + arr[k]);
                }
            }
        }
    }

    // O(2ⁿ) - Exponencial
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // O(n!) - Fatorial
    public static void permutar(String str, String resultado) {
        if (str.length() == 0) {
            System.out.println(resultado);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            permutar(str.substring(0, i) + str.substring(i + 1), resultado + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("O(1) - Constante:");
        exemploConstante();

        System.out.println("\nO(log n) - Logarítmica:");
        int[] ordenado = {1, 3, 5, 7, 9};
        System.out.println("Índice do 5: " + buscaBinaria(ordenado, 5));

        System.out.println("\nO(n) - Linear:");
        exemploLinear();

        System.out.println("\nO(n log n) - Linearítmica:");
        int[] arr = {5, 2, 9, 1, 6};
        mergeSort(arr, 0, arr.length - 1);
        for (int n : arr) System.out.print(n + " ");

        System.out.println("\n\nO(n²) - Quadrática:");
        exemploQuadratico();

        System.out.println("\nO(n³) - Cúbica:");
        exemploCubico();

        System.out.println("\nO(2ⁿ) - Exponencial:");
        System.out.println("Fibonacci de 5: " + fibonacci(5));

        System.out.println("\nO(n!) - Fatorial:");
        permutar("ABC", "");
    }
}