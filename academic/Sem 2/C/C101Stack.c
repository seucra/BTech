// Stack

#include <stdio.h>
#include <stdlib.h>
#define N 100

// Defining Structures
typedef struct Stack
{
    int a[N];
    int top;
}Stack;

// Functions
int push(Stack *s,int x);
int pop(Stack *s);
int peek(Stack *s);
int display(Stack *s);

void menu()
{
    printf("Menu\n");
    printf("\t1. Push\n");
    printf("\t2. Pop\n");
    printf("\t3. Peek\n");
    printf("\t4. Dispay\n");
    printf("\t5. Exit\n");
    printf("Enter ur choice : ");
}

// Main
int main()
{
    Stack *s = malloc(sizeof(Stack));
    if (s == NULL)
    {
        printf("Memory Allocation for Stack failed.\n");
        exit(1);
    }
    s->top = 0;
    while (1)
    {
        menu();
        int choice=0, x=0;
        scanf("%d", &choice);
        while ( getchar() != '\n');
        switch (choice)
        {
            case 1:
                printf("Enter : ");
                scanf("%d", &x);
                while ( getchar() != '\n');
                if ( !push(s, x) )
                {
                    printf("Procedure Failed.\n");
                }
                break;
            case 2:
                if ( !pop(s) )
                {
                    printf("Procedure Failed.\n");
                }
                break;
            case 3:
                if ( !peek(s) )
                {
                    printf("Procedure Failed.\n");
                }
                break;
            case 4:
                if ( !display(s) )
                {
                    printf("Procedure Failed.\n");
                }
                break;
            default:
                printf("Invalid Input.\n");
        }
    }
    free(s);
}

int push(Stack *s, int x)
{
    if (s->top == N-1)
    {
        printf("Stack Full\n");
        return 0;
    }
    if (x == 0)
    {
        printf("Invalid\n");
        return 0;
    }
    
    s->a[ ++s->top ] = x;
    return 1;
}

int pop(Stack *s)
{
    if (s->top == 0)
    {
        return 0;
    }
    return s->a[s->top--];
}

int peek(Stack *s)
{
    if (s->top == 0)
    {
        printf("Stack Empty\n");
        return 0;
    }
    printf("Peek --> %d", s->a[s->top]);
    return 1;
}

int display(Stack *s)
{
    if (s->top == 0)
    {
        printf("Stack Empty\n");
        return 0;
    }
    printf("Elements of Stack are -->");
    for (int i=0; i <= s->top; i++)
    {
        printf(" %d", s->a[i]);
    }
    printf("\n");
    return 1;
}