// Graph

#include <stdio.h>
#include <stdlib.h>

// Structure for an adjacency list node
struct AdjListNode {
    int dest;
    struct AdjListNode* next;
};

// Structure for an adjacency list
struct AdjList {
    struct AdjListNode* head;
};

// Structure for the graph
struct Graph {
    int V; // Number of vertices
    struct AdjList* array; // Array of adjacency lists
};

// Structure for a queue (used in BFS)
struct Queue {
    int* items;
    int front;
    int rear;
    int capacity;
};

// Create a new adjacency list node
struct AdjListNode* newAdjListNode(int dest) {
    struct AdjListNode* newNode = (struct AdjListNode*)malloc(sizeof(struct AdjListNode));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    newNode->dest = dest;
    newNode->next = NULL;
    return newNode;
}

// Create a graph with V vertices
struct Graph* createGraph(int V) {
    struct Graph* graph = (struct Graph*)malloc(sizeof(struct Graph));
    if (graph == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    graph->V = V;
    graph->array = (struct AdjList*)malloc(V * sizeof(struct AdjList));
    if (graph->array == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    for (int i = 0; i < V; i++) {
        graph->array[i].head = NULL;
    }
    return graph;
}

// Add an edge to an undirected graph
void addEdge(struct Graph* graph, int src, int dest) {
    // Add edge from src to dest
    struct AdjListNode* newNode = newAdjListNode(dest);
    newNode->next = graph->array[src].head;
    graph->array[src].head = newNode;

    // Add edge from dest to src (undirected)
    newNode = newAdjListNode(src);
    newNode->next = graph->array[dest].head;
    graph->array[dest].head = newNode;
}

// Create a queue
struct Queue* createQueue(int capacity) {
    struct Queue* queue = (struct Queue*)malloc(sizeof(struct Queue));
    if (queue == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    queue->capacity = capacity;
    queue->front = 0;
    queue->rear = -1;
    queue->items = (int*)malloc(capacity * sizeof(int));
    if (queue->items == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    return queue;
}

// Enqueue an item
void enqueue(struct Queue* queue, int item) {
    if (queue->rear == queue->capacity - 1) {
        printf("Queue is full!\n");
        return;
    }
    queue->items[++queue->rear] = item;
}

// Dequeue an item
int dequeue(struct Queue* queue) {
    if (queue->front > queue->rear) {
        printf("Queue is empty!\n");
        return -1;
    }
    return queue->items[queue->front++];
}

// Check if queue is empty
int isEmpty(struct Queue* queue) {
    return queue->front > queue->rear;
}

// Breadth-First Search (BFS)
void BFS(struct Graph* graph, int startVertex) {
    // Mark all vertices as not visited
    int* visited = (int*)calloc(graph->V, sizeof(int));
    if (visited == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    // Create a queue for BFS
    struct Queue* queue = createQueue(graph->V);

    // Mark the current node as visited and enqueue it
    visited[startVertex] = 1;
    enqueue(queue, startVertex);

    printf("BFS starting from vertex %d: ", startVertex);
    while (!isEmpty(queue)) {
        int currentVertex = dequeue(queue);
        printf("%d ", currentVertex);

        // Get all adjacent vertices
        struct AdjListNode* temp = graph->array[currentVertex].head;
        while (temp) {
            int adjVertex = temp->dest;
            if (!visited[adjVertex]) {
                visited[adjVertex] = 1;
                enqueue(queue, adjVertex);
            }
            temp = temp->next;
        }
    }
    printf("\n");

    free(visited);
    free(queue->items);
    free(queue);
}

// Depth-First Search (DFS) utility function
void DFSUtil(struct Graph* graph, int vertex, int* visited) {
    // Mark the current vertex as visited
    visited[vertex] = 1;
    printf("%d ", vertex);

    // Recur for all adjacent vertices
    struct AdjListNode* temp = graph->array[vertex].head;
    while (temp) {
        int adjVertex = temp->dest;
        if (!visited[adjVertex]) {
            DFSUtil(graph, adjVertex, visited);
        }
        temp = temp->next;
    }
}

// Depth-First Search (DFS)
void DFS(struct Graph* graph, int startVertex) {
    // Mark all vertices as not visited
    int* visited = (int*)calloc(graph->V, sizeof(int));
    if (visited == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }

    printf("DFS starting from vertex %d: ", startVertex);
    DFSUtil(graph, startVertex, visited);
    printf("\n");

    free(visited);
}

// Free the graph
void freeGraph(struct Graph* graph) {
    for (int i = 0; i < graph->V; i++) {
        struct AdjListNode* temp = graph->array[i].head;
        while (temp) {
            struct AdjListNode* next = temp->next;
            free(temp);
            temp = next;
        }
    }
    free(graph->array);
    free(graph);
}

// Main function to demonstrate graph operations
int main() {
    int V = 5; // Number of vertices
    struct Graph* graph = createGraph(V);

    // Add edges to create an undirected graph
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // Perform BFS
    BFS(graph, 0);

    // Perform