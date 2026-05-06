#include <stdio.h>
#include <limits.h>

#define V 6

// =========================
// BFS
// =========================
void BFS(int graph[V][V], int start) {
    int visited[V] = {0};
    int queue[V], front = 0, rear = 0;

    visited[start] = 1;
    queue[rear++] = start;

    printf("\nBFS: ");

    while (front < rear) {
        int v = queue[front++];
        printf("%d ", v);

        for (int i = 0; i < V; i++) {
            if (graph[v][i] && !visited[i]) {
                visited[i] = 1;
                queue[rear++] = i;
            }
        }
    }
}

// =========================
// DFS
// =========================
void DFS(int graph[V][V], int v, int visited[]) {
    visited[v] = 1;
    printf("%d ", v);

    for (int i = 0; i < V; i++) {
        if (graph[v][i] && !visited[i]) {
            DFS(graph, i, visited);
        }
    }
}

// =========================
// Dijkstra
// =========================
int minDistance(int dist[], int visited[]) {
    int min = INT_MAX, index;

    for (int i = 0; i < V; i++) {
        if (!visited[i] && dist[i] <= min) {
            min = dist[i];
            index = i;
        }
    }
    return index;
}

void dijkstra(int graph[V][V], int start) {
    int dist[V], visited[V];

    for (int i = 0; i < V; i++) {
        dist[i] = INT_MAX;
        visited[i] = 0;
    }

    dist[start] = 0;

    for (int count = 0; count < V - 1; count++) {
        int u = minDistance(dist, visited);
        visited[u] = 1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && graph[u][v] &&
                dist[u] != INT_MAX &&
                dist[u] + graph[u][v] < dist[v]) {
                dist[v] = dist[u] + graph[u][v];
            }
        }
    }

    printf("\nDijkstra (menor caminho a partir de %d):\n", start);
    for (int i = 0; i < V; i++) {
        printf("Vertice %d -> Distancia %d\n", i, dist[i]);
    }
}

// =========================
// MAIN
// =========================
int main() {

    int graph[V][V] = {
        {0, 1, 4, 0, 0, 0},
        {1, 0, 4, 2, 7, 0},
        {4, 4, 0, 3, 5, 0},
        {0, 2, 3, 0, 4, 6},
        {0, 7, 5, 4, 0, 7},
        {0, 0, 0, 6, 7, 0}
    };

    /*
    Visual do grafo:

        0
       / \
      1---2
       \  |
        3
       / \
      4---5
    */

    BFS(graph, 0);

    int visited[V] = {0};
    printf("\nDFS: ");
    DFS(graph, 0, visited);

    dijkstra(graph, 0);

    return 0;
}