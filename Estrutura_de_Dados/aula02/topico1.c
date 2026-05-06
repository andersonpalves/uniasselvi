#include <stdio.h>

// Função para imprimir o vetor
void printArray(int arr[], int n) {
    for (int i = 0; i < n; i++) printf("%d ", arr[i]);
    printf("\n");
}

// ---------------- BUBBLE SORT ----------------
void bubbleSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

// ---------------- SELECTION SORT ----------------
void selectionSort(int arr[], int n) {
    for (int i = 0; i < n-1; i++) {
        int min_idx = i;
        for (int j = i+1; j < n; j++) {
            if (arr[j] < arr[min_idx]) min_idx = j;
        }
        int temp = arr[min_idx];
        arr[min_idx] = arr[i];
        arr[i] = temp;
    }
}

// ---------------- INSERTION SORT ----------------
void insertionSort(int arr[], int n) {
    for (int i = 1; i < n; i++) {
        int key = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > key) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = key;
    }
}

// ---------------- SHELL SORT ----------------
void shellSort(int arr[], int n) {
    for (int gap = n/2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j >= gap && arr[j-gap] > temp; j -= gap) {
                arr[j] = arr[j-gap];
            }
            arr[j] = temp;
        }
    }
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
    printArray(arr1, n);

    printf("\nSelection Sort:\n");
    selectionSort(arr2, n);
    printArray(arr2, n);

    printf("\nInsertion Sort:\n");
    insertionSort(arr3, n);
    printArray(arr3, n);

    printf("\nShell Sort:\n");
    shellSort(arr4, n);
    printArray(arr4, n);

    return 0;
}
