#include <stdio.h>
#include <stdlib.h>

// Estrutura do nó
struct Node {
    int data;
    struct Node* left;
    struct Node* right;
};

// Cria um novo nó
struct Node* newNode(int data) {
    struct Node* node = (struct Node*)malloc(sizeof(struct Node));
    node->data = data;
    node->left = node->right = NULL;
    return node;
}

// Inserção na árvore binária de busca
struct Node* insert(struct Node* node, int data) {
    if (node == NULL) return newNode(data);

    if (data < node->data)
        node->left = insert(node->left, data);
    else if (data > node->data)
        node->right = insert(node->right, data);

    return node;
}

// Impressão visual simples (passo a passo)
void printTreeStep(struct Node* root, int space) {
    if (root == NULL) return;

    space += 5;
    printTreeStep(root->right, space);

    printf("\n");
    for (int i = 5; i < space; i++) printf(" ");
    printf("%d\n", root->data);

    printTreeStep(root->left, space);
}

// Impressão final com traços
void printTreeFinal(struct Node* root, int level) {
    if (root == NULL) return;

    printTreeFinal(root->right, level + 1);

    for (int i = 0; i < level; i++) printf("    ");
    if (level > 0) printf("|-- ");
    printf("%d\n", root->data);

    printTreeFinal(root->left, level + 1);
}

int main() {
    struct Node* root = NULL;
    int valores[] = {10, 7, 15, 3, 8, 12, 20};
    int n = sizeof(valores)/sizeof(valores[0]);

    printf("Construção da Árvore Binária (passo a passo):\n");

    // Inserindo valores na árvore passo a passo
    for (int i = 0; i < n; i++) {
        root = insert(root, valores[i]);
        printf("\nApós inserir %d:\n", valores[i]);
        printTreeStep(root, 0);
    }

    printf("\nVisualização final da Árvore Binária com traços:\n");
    printTreeFinal(root, 0);

    return 0;
}
