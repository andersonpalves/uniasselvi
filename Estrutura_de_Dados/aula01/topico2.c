#include <stdio.h>
#include <stdlib.h>

#define MAX 5

// ---------------- FILA (Queue - FIFO) ----------------
typedef struct {
    int itens[MAX];
    int frente, tras;
} Fila;

void inicializaFila(Fila *f) {
    f->frente = 0;
    f->tras = -1;
}

int filaCheia(Fila *f) {
    return f->tras == MAX - 1;
}

int filaVazia(Fila *f) {
    return f->frente > f->tras;
}

void enqueue(Fila *f, int valor) {
    if (filaCheia(f)) {
        printf("Fila Overflow! Não é possível enfileirar %d\n", valor);
    } else {
        f->itens[++f->tras] = valor;
        printf("Enqueue: %d\n", valor);
    }
}

int dequeue(Fila *f) {
    if (filaVazia(f)) {
        printf("Fila Vazia! Não é possível desenfileirar\n");
        return -1;
    } else {
        int valor = f->itens[f->frente++];
        printf("Dequeue: %d\n", valor);
        return valor;
    }
}

// ---------------- PILHA (Stack - LIFO) ----------------
typedef struct {
    int itens[MAX];
    int topo;
} Pilha;

void inicializaPilha(Pilha *p) {
    p->topo = -1;
}

int pilhaCheia(Pilha *p) {
    return p->topo == MAX - 1;
}

int pilhaVazia(Pilha *p) {
    return p->topo == -1;
}

void push(Pilha *p, int valor) {
    if (pilhaCheia(p)) {
        printf("Pilha Overflow! Não é possível empilhar %d\n", valor);
    } else {
        p->itens[++p->topo] = valor;
        printf("Push: %d\n", valor);
    }
}

int pop(Pilha *p) {
    if (pilhaVazia(p)) {
        printf("Pilha Vazia! Não é possível desempilhar\n");
        return -1;
    } else {
        int valor = p->itens[p->topo--];
        printf("Pop: %d\n", valor);
        return valor;
    }
}

// ---------------- MAIN ----------------
int main() {
    Fila f;
    Pilha p;

    inicializaFila(&f);
    inicializaPilha(&p);

    // Testando Fila (FIFO)
    printf("\n--- Teste da Fila (FIFO) ---\n");
    enqueue(&f, 10);
    enqueue(&f, 20);
    enqueue(&f, 30);
    enqueue(&f, 40);
    enqueue(&f, 50);
    enqueue(&f, 60);
    dequeue(&f);
    dequeue(&f);
    dequeue(&f);
    dequeue(&f); // tentativa extra para mostrar fila vazia

    // Testando Pilha (LIFO)
    printf("\n--- Teste da Pilha (LIFO) ---\n");
    push(&p, 100);
    push(&p, 200);
    push(&p, 300);
    pop(&p);
    pop(&p);
    pop(&p);
    pop(&p); // tentativa extra para mostrar pilha vazia

    return 0;
}
