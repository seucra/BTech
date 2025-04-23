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
Contact contacts[100];      // Array for Contacts
int contactcount = 0;
Node *head = NULL;

// Adding Contact
void addContact();

// Display 
void Display();


int main()
{
    while (1)
    {
        printf("1. Add Contact\t2. Display\t3. Search\n4. Sync\t5. Undo\t6. Save\t7. Load\n8. Exit\n");
        int ch;
        if (scanf("%d", &ch) != 1)
        {
            printf("Invalid Input.\n");
            while (getchar() != '\n');
            continue;
        }
        if (ch == 8)
        {
            printf("Exiting the Progarm...");
            break;
        }
        switch (ch)
        {
            case 1:
                printf("To add contact...");
                printf("Enter Name : ");
                printf("Enter Phone : ");
                printf("Enter email : ");

                break;

            case 2:
                printf("To Display Contact...");

                break;

            case 3:
                printf("Searching Contact...");
            
                break;

            case 4:
                printf("Syncing Contacts...");
            
                break;
            
            case 5:
                printf("Undoing Last Action...");
            
            
            case 6:
                printf("Saving Contacts...");
                
                break;
        
            case 7:
                printf("Loading Contacts...");
            
                break;
    
            default:
                printf("Invalid Input.\n");
                if (scanf("%d", &ch) != 1)
                {
                    while (getchar() != '\n');
                    continue;
                }
                break;
        }
    }
}
