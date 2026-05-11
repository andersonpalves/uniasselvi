#include <stdio.h>

// Função para imprimir o vetor
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);
    printf("\n");
}

// ---------------- BUBBLE SORT ----------------
void bubbleSort(int arr[], int n) {
    printf("Estado inicial (Bubble Sort):\n");
    printArray(arr, n);

    for (int i = 0; i < n-1; i++) {
        int trocou = 0;
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                if (!trocou) printf("\nPasso Bubble %d:\n", i+1);
                printArray(arr, n);
                trocou = 1;
            }
        }
        if (!trocou) break; // encerra se já está ordenado
    }
    printf("\nResultado final (Bubble Sort):\n");
    printArray(arr, n);
}

// ---------------- SELECTION SORT ----------------
void selectionSort(int arr[], int n) {
    printf("Estado inicial (Selection Sort):\n");
    printArray(arr, n);

    for (int i = 0; i < n-1; i++) {
        int min_idx = i;
        for (int j = i+1; j < n; j++) {
            if (arr[j] < arr[min_idx]) min_idx = j;
        }
        if (min_idx != i) { // só imprime se houve troca
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            printf("\nPasso Selection %d:\n", i+1);
            printArray(arr, n);
        }
    }
    printf("\nResultado final (Selection Sort):\n");
    printArray(arr, n);
}

// ---------------- INSERTION SORT ----------------
void insertionSort(int arr[], int n) {
    printf("Estado inicial (Insertion Sort):\n");
    printArray(arr, n);

    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        int mudou = 0;
        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
            if (!mudou) printf("\nInserindo %d:\n", key);
            printArray(arr, n);
            mudou = 1;
        }
        arr[j+1] = key;
        if (mudou) printArray(arr, n);
    }
    printf("\nResultado final (Insertion Sort):\n");
    printArray(arr, n);
}

// ---------------- SHELL SORT ----------------
void shellSort(int arr[], int n) {
    printf("Estado inicial (Shell Sort):\n");
    printArray(arr, n);

    for (int gap = n/2; gap > 0; gap /= 2) {
        int houveMudanca = 0;
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j;
            int mudou = 0;
            for (j = i; j >= gap && arr[j-gap] > temp; j -= gap) {
                arr[j] = arr[j-gap];
                if (!mudou) {
                    if (!houveMudanca) printf("\nGap = %d:\n", gap);
                    houveMudanca = 1;
                }
                printArray(arr, n);
                mudou = 1;
            }
            arr[j] = temp;
            if (mudou) printArray(arr, n);
        }
    }
    printf("\nResultado final (Shell Sort):\n");
    printArray(arr, n);
}

// ---------------- MAIN ----------------
int main() {
    int arr1[] = {64, 34, 25, 12, 22, 11, 90};
    int arr2[] = {64, 34, 25, 12, 22, 11, 90};
    int arr3[] = {64, 34, 25, 12, 22, 11, 90};
    int arr4[] = {64, 34, 25, 12, 22, 11, 90};
    int n = sizeof(arr1)/sizeof(arr1[0]);

    printf("Bubble Sort:\n");
    bubbleSort(arr1, n);

    printf("\nSelection Sort:\n");
    selectionSort(arr2, n);

    printf("\nInsertion Sort:\n");
    insertionSort(arr3, n);

    printf("\nShell Sort:\n");
    shellSort(arr4, n);

    return 0;
}
