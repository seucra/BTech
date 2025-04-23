#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Struct DEfinitions
typedef struct Contact
{
    char name[50], phone[11], email[50];
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
    struct StackNode *prev;
}StackNode;

typedef struct Stack
{
    StackNode *top;
    int top;
}Stack;

// Global Variables
Contact *contacts[100];          // Array for Contacts
int contactcount = 0;
Node *head = NULL;              // Linked List Head
Node *bstRoot = NULL;           // BST Root
GraphNode *adj[100] = {NULL};   // Graph Adjecency List
Queue queue = {NULL, NULL};     // Queue for Sync Request
Stack *stack = {NULL, 0};           // Stack for Undo Actions

// Function Declarations
// Array Functions
int addContact();
int displayContacts();

// Linked List Functions
int addToList(Contact c);
int displayList();
int deleteFromList(char *name);

// Queue Functions
int enqueue(Queue *q, char *request);
char* dequeue(Queue *q);

// Stack Functions
int push(Stack *s, char *action);
char* pop(Stack *s);

// BST Functions
struct Node* insertBST(Node *root, Contact c);
struct Node* searchBST(Node *root, char *name);
void displayBST(Node *root);
/**
// Graph Functions
void addEdge(int from, int to);
void bfs(int start);
*/
// File Handling Functions
int saveContacts();
int loadContacts();


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
        while(getchar() != '\n'); // Clear input buffer

        switch (choice) {
            case 1: // Add Contact
                if ( !addContact() )
                {
                    printf("Procedure Unsuccesful.\n\n");
                }
                break;
            case 2: // Display Contacts (Array)
                if ( !displayContacts() )
                {
                    printf("Procedure Unsuccessful.\n\n");
                }
                break;
            case 3: // Display Contacts (Linked List)
                if ( !displayList() )
                {
                    printf("Procedure Unsuccessful.\n\n");
                }
                break;
            case 4: // Delete Contact
                printf("Enter name to delete: ");
                char name[50];
                fgets(name, sizeof(name), stdin);
                name[strcspn(name, "\n")] = '\0';
                if ( deleteFromList(name) )
                {
                    printf("Procedure Sucessfully.\n\n");
                }
                else
                {
                    printf("Procedure Unsuccessful.\n\n");
                }
                break;
/**            case 5: // Search Contact (BST)
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
*/            case 9: // Save to File
                saveContacts();
                break;
            case 10: // Load from File
                loadContacts();
                break;
            case 11: // Exit
                return 0;
            default:
                printf("Invalid choice\n\n");
        }
    }
}


// Function Implementations
int addContact()
{
    if (contactcount >= 100)
    {
        printf("Array Full...\n");
        return 0;
    }

    contacts[contactcount] = malloc(sizeof(Contact));
    if (contacts[contactcount] == NULL)
    {
        printf("Memory Allocation for Contact failled...\n");
        return 0;
    }

    char name[50],phone[11],email[50];

    printf("Enter Name : ");
    fgets(name, sizeof(name), stdin);
    name[strcspn(name, "\n")] = '\0';

    printf("Enter phone number : ");
    fgets(phone, sizeof(phone), stdin);
    phone[strcspn(phone, "\n")] = '\0';
    if (strlen(phone) != 10 || strspn(phone, "0123456789") != 10)
    {
        printf("Invalid Phone Number...\n");
        return 0;
    }

    while(getchar() != '\n');
    printf("Enter email : ");
    fgets(email, sizeof(email), stdin);
    email[strcspn(email, "\n")] = '\0';
    if (strchr(email, '@') == NULL || strchr(email, '.') == NULL || strchr(email, '@') > strchr(email, '.'))
    {
        printf("Invalid Email ID...\n");
        return 0;
    }

    strcpy(contacts[contactcount]->name , name);
    strcpy(contacts[contactcount]->phone , phone);
    strcpy(contacts[contactcount]->email , email);

    if ( !addToList(*contacts[contactcount]) )
    {
        free(contacts[contactcount]);
        return 0;
    }

    contactcount++;
    return 1;
}

int displayContacts()
{
    if (contactcount == 0)
    {
        return 0;
    }
    printf("Displaying Contacts Stored in Array.\n---\n");
    printf("Index\tName\t\t\tPhone\t\t\tEmail\n---\n");
    for (int i=0; i<contactcount; i++)
    {
        if (contacts[i] != NULL)
        {
            printf("%d : %-20s : %-15s : %-30s\n", i+1, contacts[i]->name , contacts[i]->phone, contacts[i]->email);
        }
    }

    printf("---\nDisplay Complete\n\n");
    return 1;
}

int addToList(Contact c)
{
    if (c.name[0] == '\0')
    {
        printf("Name is NULL");
        return 0;
    }
    Node *newNode = malloc(sizeof(QueueNode));
    if (newNode == NULL)
    {
        printf("Memory Allocation for Contact failled...\n");
        return 0;
    }

    char req[100];
    sprintf(req, "add:%s,%s,%s", c.name, c.phone, c.email);
    if ( !enqueue(&queue, req) )
    {
        printf("Memory Allocation for Sync Request Failled...\n");
        free(newNode);
        return 0;
    }

    newNode->contact = c;
    newNode->next = head;
    newNode->left = newNode->right = NULL;
    head = newNode;

    printf("\nAdded to Contacts\n\t%s : %s : %s\n\n", c.name, c.phone, c.email);
    return 1;
}

int displayList()
{
    if (head == NULL)
    {
        printf("Memory Empty...\n");
        return 0;
    }

    printf("Displaying Contacts Stored in LinkedList.\n---\n");
    printf("Index\tName\t\t\tPhone\t\t\tEmail\n---\n");
    int i=0;
    Node *pointer = head;
    while (pointer != NULL)
    {
        printf("%d : %-20s : %-15s : %-30s\n", contactcount-i, pointer->contact.name , pointer->contact.phone, pointer->contact.email);
        i++;
        pointer = pointer->next;
    }

    printf("---\nDisplay Complete\n\n");
    return 1;
}

int deleteFromList(char *name)
{
    if (head == NULL)
    {
        printf("Memory Empty...\n");
        return 0;
    }

    Node *delnode, *pointer = head;

    if ( !strcmp(head->contact.name , name))
    {
        head = head->next;
        free(pointer);
        contacts[contactcount-1] = NULL;
        return 1;
    }

    int index = contactcount-1;
    while (strcmp(pointer->next->contact.name , name))
    {
        index--;
        pointer = pointer->next;
        if (pointer == NULL)
        {
            printf("Name Not Found...\n");
            return 0;
        }
    }
    contacts[index] = NULL;

    delnode = pointer->next;
    pointer->next = pointer->next->next;
    free(delnode);
    contactcount--;

    return 1;
}

int enqueue(Queue *q, char *request)
{
    QueueNode *newNode = malloc(sizeof(QueueNode));
    if (newNode == NULL)
    {
        printf("Memory Allocation Failed...");
        return 0;
    } 

    strcpy(newNode->request, request);
    newNode->next = NULL;

    if (q->rear == NULL)
    {
        q->front = q->rear = newNode;
    }
    else
    {
        q->rear->next = newNode;
        q->rear = newNode;
    }

    printf("Request Enqueued...\n");
    return 1;
}

char* dequeue(Queue *q)
{
    if (q == NULL)
    {
        printf("Queue is empty. Nothing to Dequeue.\n");
        return NULL;
    }

    QueueNode *pointer = q->front;
    char *req = malloc(sizeof(pointer->request));
    strcpy(req, pointer->request);

    q->front = pointer->next;
    if (q->front == NULL)
    {
        q->rear = NULL;
    }
    free(pointer);

    printf("Request Dequeued...\n");
    return req;
}

int saveContacts()
{
    FILE *myfile;

    myfile = fopen("data.csv", "a");
    if (myfile == NULL)
    {
        printf("File Openning Failed...\n");
        return 0;
    }

    for (int i=0; i<contactcount; i++)
    {
        if (contacts[i] != NULL)  // Avoid dereferencing NULL pointers
        {
            fprintf(myfile, "%s,%s,%s\n", contacts[i]->name, contacts[i]->phone, contacts[i]->email);
        }
        else
        {
            printf("Invalid contact at index %d\n", i);
        }
    }

    fclose(myfile);
    return 1;
}

int loadContacts()
{
    FILE *myfile;
    char line[1000];
    char *token;

    myfile = fopen("data.csv", "r");
    if (myfile == NULL)
    {
        printf("File Openning Failed...\n");
        return 0;
    }

    // Read Each Line
    if (fgets(line, sizeof(line), myfile) == NULL)
    {
        printf("File is Empty...\n");
        fclose(myfile);
        return 0;
    }
    do
    {
        if (contactcount >= 100)
        {
            printf("Max contact limit reached...\n");
            break;
        }

        contacts[contactcount] = malloc(sizeof(Contact));
        if (contacts[contactcount] == NULL)
        {
            printf("Memory Allocation for Contact failled...\n");
            return 0;
        }

        // Split line into tokens based on comma
        token = strtok(line, ",");
        if (token != NULL) {
            strcpy(contacts[contactcount]->name, token);  // Store name
        }

        token = strtok(NULL,  ",");
        if (token != NULL) {
            strcpy(contacts[contactcount]->phone , token);
        }

        token = strtok(NULL,  ",");
        if (token != NULL) {
            strcpy(contacts[contactcount]->email , token);
        }

        if ( !addToList(*contacts[contactcount]) )
        {
            free(contacts[contactcount]);
            return 0;
        }

        contactcount++;
    } while (fgets(line, sizeof(line), myfile));

    fclose(myfile);
    return 1;
}

int push(char *action)
{
    
    StackNode *newNode = malloc(sizeof(StackNode));
    if (newNode == NULL)
    {
        printf("Memory Allocation for Stack Failed...\n");
        return 0;
    }
    strcpy(newNode->action, action);
    newNode->prev = stack->top;
    stack->top = newNode;
    return 1;
}

char* pop(Stack *s)
{
    if (s->top == 0)
    {
        printf("Stack Empty...\n");
        return NULL;
    }
    StackNode *pointer = s->top;
    s->top = s->top->prev;

    char action[100];
    strcpy(action, pointer->action);

    free(pointer);
    return action;
}

Node* insertBST(Node *root, Contact c)
{
    if (root == NULL)
    {
        Node *newNode = malloc(sizeof(Node));
        if (newNode == NULL)
        {
            printf("Memory Allocation Failed...\n");
            return NULL;
        }
        newNode->contact = c;
        newNode->left = newNode->right = NULL;
        return newNode;
    }

    if (strcmp(c.name, root->contact.name) < 0)
    {
        root->left = insertBST(root->left, c);
    }
    else
    {
        root->right = insertBST(root->right, c);
    }

    return root;
}

