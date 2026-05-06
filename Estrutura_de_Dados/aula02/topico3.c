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

// Impressão visual da árvore (em formato hierárquico)
void printTree(struct Node* root, int space) {
    if (root == NULL) return;

    // Aumenta a distância entre níveis
    space += 5;

    // Imprime subárvore da direita primeiro
    printTree(root->right, space);

    // Imprime o nó atual com indentação
    printf("\n");
    for (int i = 5; i < space; i++) printf(" ");
    printf("%d\n", root->data);

    // Imprime subárvore da esquerda
    printTree(root->left, space);
}

int main() {
    struct Node* root = NULL;
    int valores[] = {10, 7, 15, 3, 8, 12, 20};
    int n = sizeof(valores)/sizeof(valores[0]);

    // Inserindo valores na árvore
    for (int i = 0; i < n; i++) {
        root = insert(root, valores[i]);
    }

    printf("Visualização da Árvore Binária:\n");
    printTree(root, 0);

    return 0;
}
