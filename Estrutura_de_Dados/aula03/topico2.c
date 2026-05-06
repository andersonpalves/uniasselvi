#include <stdio.h>
#include <stdlib.h>

#define MAX 10

// Estrutura do nó
typedef struct Node {
    int vertex;
    struct Node* next;
} Node;

// Estrutura do grafo
typedef struct {
    Node* adj[MAX];
    int numVertices;
} Graph;

// Criar nó
Node* createNode(int v) {
    Node* newNode = (Node*) malloc(sizeof(Node));
    newNode->vertex = v;
    newNode->next = NULL;
    return newNode;
}

// Criar grafo
Graph* createGraph(int vertices) {
    Graph* graph = (Graph*) malloc(sizeof(Graph));
    graph->numVertices = vertices;

    for (int i = 0; i < vertices; i++)
        graph->adj[i] = NULL;

    return graph;
}

// Adicionar aresta DIRECIONADA (Dígrafo)
void addEdgeDirected(Graph* graph, int src, int dest) {
    Node* newNode = createNode(dest);
    newNode->next = graph->adj[src];
    graph->adj[src] = newNode;
}

// Imprimir grafo
void printGraph(Graph* graph) {
    printf("\nRepresentacao do Digrafo:\n");
    for (int i = 0; i < graph->numVertices; i++) {
        printf("%d -> ", i);
        Node* temp = graph->adj[i];
        while (temp) {
            printf("%d -> ", temp->vertex);
            temp = temp->next;
        }
        printf("NULL\n");
    }
}

int main() {

    Graph* g = createGraph(5);

    // Criando um Dígrafo (direcionado)
    addEdgeDirected(g, 0, 1);
    addEdgeDirected(g, 0, 2);
    addEdgeDirected(g, 1, 3);
    addEdgeDirected(g, 2, 3);
    addEdgeDirected(g, 3, 4);

    printf("=== DIGRAFO (GRAFO ORIENTADO) ===\n");
    printGraph(g);

    /*
    Visual:

    0 → 1 → 2
    1 → 3
    2 → 3
    3 → 4
    4

    Aplicação:
    - Redes sociais (seguir alguém)
    - Rotas com sentido único
    - Fluxo de processos
    */

    return 0;
}