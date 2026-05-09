#include <stdio.h>

int main() {
    // Exemplos de tipos primitivos em C

    // Inteiros
    char c = 'A';                // caractere
    short s = 32000;             // inteiro curto
    int i = 100000;              // inteiro padrão
    long l = 1000000L;           // inteiro longo
    long long ll = 10000000000LL;// inteiro muito longo

    // Números com ponto flutuante
    float f = 3.14f;             // precisão simples
    double d = 3.14159265359;    // precisão dupla
    long double ld = 3.141592653589793238L; // precisão estendida

    // Booleano
    _Bool b = 1;                 // 0 = falso, 1 = verdadeiro

    // Void não pode ser instanciado, usado em funções

    // Unsigned (sem sinal, apenas positivos)
    unsigned int ui = 4000000000U;

    printf("Tipos primitivos em C:\n");
    printf("char: %c (tamanho: %zu bytes)\n", c, sizeof(char));
    printf("short: %d (tamanho: %zu bytes)\n", s, sizeof(short));
    printf("int: %d (tamanho: %zu bytes)\n", i, sizeof(int));
    printf("long: %ld (tamanho: %zu bytes)\n", l, sizeof(long));
    printf("long long: %lld (tamanho: %zu bytes)\n", ll, sizeof(long long));
    printf("float: %.2f (tamanho: %zu bytes)\n", f, sizeof(float));
    printf("double: %.10f (tamanho: %zu bytes)\n", d, sizeof(double));
    printf("long double: %.15Lf (tamanho: %zu bytes)\n", ld, sizeof(long double));
    printf("_Bool: %d (tamanho: %zu bytes)\n", b, sizeof(_Bool));
    printf("unsigned int: %u (tamanho: %zu bytes)\n", ui, sizeof(unsigned int));

    return 0;
}
