#include <stdio.h>
#include <stdlib.h>

// ---------------- Lista Simplesmente Encadeada ----------------
typedef struct NodeSimples {
    int valor;
    struct NodeSimples *prox;
} NodeSimples;

void exemploListaSimples() {
    NodeSimples *n1 = malloc(sizeof(NodeSimples));
    NodeSimples *n2 = malloc(sizeof(NodeSimples));
    NodeSimples *n3 = malloc(sizeof(NodeSimples));

    n1->valor = 10; n1->prox = n2;
    n2->valor = 20; n2->prox = n3;
    n3->valor = 30; n3->prox = NULL;

    printf("\nLista Simplesmente Encadeada:\n");
    NodeSimples *atual = n1;
    while(atual != NULL) {
        printf("%d -> ", atual->valor);
        atual = atual->prox;
    }
    printf("NULL\n");
}

// ---------------- Lista Duplamente Encadeada ----------------
typedef struct NodeDuplo {
    int valor;
    struct NodeDuplo *prox;
    struct NodeDuplo *ant;
} NodeDuplo;

void exemploListaDupla() {
    NodeDuplo *n1 = malloc(sizeof(NodeDuplo));
    NodeDuplo *n2 = malloc(sizeof(NodeDuplo));
    NodeDuplo *n3 = malloc(sizeof(NodeDuplo));

    n1->valor = 10; n1->ant = NULL; n1->prox = n2;
    n2->valor = 20; n2->ant = n1;   n2->prox = n3;
    n3->valor = 30; n3->ant = n2;   n3->prox = NULL;

    printf("\nLista Duplamente Encadeada:\n");
    NodeDuplo *atual = n1;
    while(atual != NULL) {
        printf("%d <-> ", atual->valor);
        atual = atual->prox;
    }
    printf("NULL\n");
}

// ---------------- Lista Circular ----------------
typedef struct NodeCircular {
    int valor;
    struct NodeCircular *prox;
} NodeCircular;

void exemploListaCircular() {
    NodeCircular *n1 = malloc(sizeof(NodeCircular));
    NodeCircular *n2 = malloc(sizeof(NodeCircular));
    NodeCircular *n3 = malloc(sizeof(NodeCircular));

    n1->valor = 10; n1->prox = n2;
    n2->valor = 20; n2->prox = n3;
    n3->valor = 30; n3->prox = n1; // volta para o primeiro nó

    printf("\nLista Circular:\n");
    NodeCircular *atual = n1;
    int count = 0;
    while(count < 6) { // percorre duas voltas
        printf("%d -> ", atual->valor);
        atual = atual->prox;
        count++;
    }
    printf("...\n");
}

// ---------------- Lista Duplamente Encadeada Circular ----------------
typedef struct NodeDuploCircular {
    int valor;
    struct NodeDuploCircular *prox;
    struct NodeDuploCircular *ant;
} NodeDuploCircular;

void exemploListaDuplaCircular() {
    NodeDuploCircular *n1 = malloc(sizeof(NodeDuploCircular));
    NodeDuploCircular *n2 = malloc(sizeof(NodeDuploCircular));
    NodeDuploCircular *n3 = malloc(sizeof(NodeDuploCircular));

    n1->valor = 10;
    n2->valor = 20;
    n3->valor = 30;

    // ligações circulares
    n1->prox = n2; n1->ant = n3;
    n2->prox = n3; n2->ant = n1;
    n3->prox = n1; n3->ant = n2;

    printf("\nLista Duplamente Encadeada Circular:\n");
    NodeDuploCircular *atual = n1;
    int count = 0;
    while(count < 6) { // percorre duas voltas
        printf("%d <-> ", atual->valor);
        atual = atual->prox;
        count++;
    }
    printf("...\n");
}

// ---------------- MAIN ----------------
int main() {
    exemploListaSimples();
    exemploListaDupla();
    exemploListaCircular();
    exemploListaDuplaCircular();
    return 0;
}
