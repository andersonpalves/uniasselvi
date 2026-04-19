#include <stdio.h>
#include <string.h>

// Definição de um registro (struct)
typedef struct {
    char nome[50];
    int idade;
} Pessoa;

// Função que altera os dados de uma struct usando ponteiro
void alteraPessoa(Pessoa *p, const char *novoNome, int novaIdade) {
    strcpy(p->nome, novoNome);   // altera o campo nome
    p->idade = novaIdade;        // altera o campo idade
}

int main() {
    // Exemplo de vetor
    int vetor[5] = {1, 2, 3, 4, 5};
    printf("Vetor:\n");
    for (int i = 0; i < 5; i++) {
        printf("vetor[%d] = %d\n", i, vetor[i]);
    }

    // Exemplo de matriz
    int matriz[2][3] = {
        {1, 2, 3},
        {4, 5, 6}
    };
    printf("\nMatriz:\n");
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            printf("matriz[%d][%d] = %d\n", i, j, matriz[i][j]);
        }
    }

    // Exemplo de registro
    Pessoa p1;
    strcpy(p1.nome, "Ana");
    p1.idade = 25;

    Pessoa p2 = {"Carlos", 30};

    printf("\nRegistros:\n");
    printf("Pessoa 1: %s, %d anos\n", p1.nome, p1.idade);
    printf("Pessoa 2: %s, %d anos\n", p2.nome, p2.idade);

    // Exemplo de ponteiros
    int x = 10;
    int *ptr = &x;

    printf("\nPonteiros:\n");
    printf("Valor de x: %d\n", x);
    printf("Endereço de x: %p\n", (void*)ptr);
    printf("Valor via ponteiro: %d\n", *ptr);

    // Ponteiro para struct
    Pessoa *ptrPessoa = &p2;
    printf("\nAcessando struct via ponteiro:\n");
    printf("Nome: %s, Idade: %d\n", ptrPessoa->nome, ptrPessoa->idade);

    // Alterando struct via função com ponteiro
    alteraPessoa(ptrPessoa, "Mariana", 28);
    printf("\nStruct alterada via ponteiro:\n");
    printf("Nome: %s, Idade: %d\n", ptrPessoa->nome, ptrPessoa->idade);

    return 0;
}
