#include <stdio.h>

// Struct DEfinitions
typedef struct Contact
{
    char name[50], phone[15], email[50];
}Contact;

typedef struct Node
{
    Contact contact;
    struct Node *next;  // For LL
    struct Node *left, *right; // For BST
}Node;

typedef struct GraphNode
{
    int contactID; // Index in Contacts[] array
    struct GraphNode *next;
}GraphNode;

typedef struct QueueNode
{
    char request[100];          // Eg: "add:John,1234567890,abs@cde.com"
    struct QueueNode *next;
}QueueNode;

typedef struct Queue
{
    QueueNode *front, *rear;
}Queue;

typedef struct StackNode
{
    char action[100];       // Eg: "add:hohn,1234567890"
    struct StackNode *next;
}StackNode;

typedef struct Stack
{
    StackNode *top;
}Stack;

// Global Variables
Contact contacts[100];          // Array for Contacts
int contactcount = 0;
Node *head = NULL;              // Linked List Head
Node *bstRoot = NULL;           // BST Root
GraphNode *adj[100] = {NULL};   // Graph Adjecency List
Queue queue = {NULL, NULL};     // Queue for Sync Request
Stack stack = {NULL};           // Stack for Undo Actions

// Function Declarations
// Array Functions
void addContact();
void displayContacts();

// Linked List Functions
void addToList(struct Contact c);
void displayList();
void deleteFromList(char *name);

// Queue Functions
void enqueue(struct Queue *q, char *request);
char* dequeue(struct Queue *q);

// Stack Functions
void push(struct Stack *s, char *action);
char* pop(struct Stack *s);

// BST Functions
struct Node* insertBST(struct Node *root, struct Contact c);
struct Node* searchBST(struct Node *root, char *name);
void displayBST(struct Node *root);

// Graph Functions
void addEdge(int from, int to);
void bfs(int start);

// File Handling Functions
void saveContacts();
void loadContacts();


// Main Function
int main()
{
    int choice;
    while (1)
    {
        printf("1. Add Contact\n");
        printf("2. Display Contacts (Array)\n");
        printf("3. Display Contacts (Linked List)\n");
        printf("4. Delete Contact\n");
        printf("5. Search Contact (BST)\n");
        printf("6. Sync Requests\n");
        printf("7. Undo\n");
        printf("8. Find Mutual Contacts (BFS)\n");
        printf("9. Save to File\n");
        printf("10. Load from File\n");
        printf("11. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &choice);
        getchar(); // Clear input buffer

        switch (choice) {
            case 1: // Add Contact
                addContact();
                break;
            case 2: // Display Contacts (Array)
                displayContacts();
                break;
            case 3: // Display Contacts (Linked List)
                displayList();
                break;
            case 4: // Delete Contact
                printf("Enter name to delete: ");
                char name[50];
                scanf("%49s", name);
                deleteFromList(name);
                break;
            case 5: // Search Contact (BST)
                printf("Enter name to search: ");
                scanf("%49s", name);
                searchBST(bstRoot, name);
                break;
            case 6: // Sync Requests
                dequeue(&queue);
                break;
            case 7: // Undo
                pop(&stack);
                break;
            case 8: // Find Mutual Contacts (BFS)
                printf("Enter contact ID: ");
                int id;
                scanf("%d", &id);
                bfs(id);
                break;
            case 9: // Save to File
                saveContacts();
                break;
            case 10: // Load from File
                loadContacts();
                break;
            case 11: // Exit
                return 0;
            default:
                printf("Invalid choice\n");
        }
    }
}
