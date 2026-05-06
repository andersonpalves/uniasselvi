#include <stdio.h>
#include <stdlib.h>

// Estrutura do nó
typedef struct Node {
    int value;
    struct Node* left;
    struct Node* right;
} Node;

// Criar nó
Node* createNode(int value) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    newNode->value = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

// Inserção (BST)
Node* insert(Node* root, int value) {
    if (root == NULL) return createNode(value);

    if (value < root->value)
        root->left = insert(root->left, value);
    else
        root->right = insert(root->right, value);

    return root;
}

// Busca
int search(Node* root, int value) {
    if (root == NULL) return 0;

    if (root->value == value) return 1;

    if (value < root->value)
        return search(root->left, value);
    else
        return search(root->right, value);
}

// Impressão visual (rotacionada)
void printTree(Node* root, int level) {
    if (root == NULL) return;

    printTree(root->right, level + 1);

    for (int i = 0; i < level; i++)
        printf("    ");

    printf("%d\n", root->value);

    printTree(root->left, level + 1);
}

int main() {

    Node* unbalanced = NULL;
    Node* balanced = NULL;

    // ---------------------------
    // Árvore DESBALANCEADA
    // Inserção ordenada (vira "lista")
    // ---------------------------
    int values_unbalanced[] = {10, 20, 30, 40, 50};

    for (int i = 0; i < 5; i++)
        unbalanced = insert(unbalanced, values_unbalanced[i]);

    printf("=== ARVORE DESBALANCEADA ===\n");
    printTree(unbalanced, 0);

    /*
    Visual esperado:

            50
        40
    30
        20
            10
    */

    // ---------------------------
    // Árvore BALANCEADA
    // Inserção manual equilibrada
    // ---------------------------
    int values_balanced[] = {30, 20, 40, 10, 25, 35, 50};

    for (int i = 0; i < 7; i++)
        balanced = insert(balanced, values_balanced[i]);

    printf("\n=== ARVORE BALANCEADA ===\n");
    printTree(balanced, 0);

    /*
    Visual esperado:

            50
        40
            35
    30
            25
        20
            10
    */

    // ---------------------------
    // BUSCA
    // ---------------------------
    int target = 25;

    printf("\nBusca por %d na árvore balanceada: ", target);
    if (search(balanced, target))
        printf("ENCONTRADO\n");
    else
        printf("NAO ENCONTRADO\n");

    return 0;
}