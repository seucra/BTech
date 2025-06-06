// Linked List: Circular Queue Implementation

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct node
{
    char data[100];
    struct node *next, *prev;
}node;

typedef struct LL
{
    node *start;
    node *end;
}LL;


int count(LL *l)
{
    node *p = l->start;
    int c=0;
    while (p != NULL)
    {
        c++;
        p = p->next;
    }
    return c;
}

void insertbeg(LL *l, char *x)
{
    node *newrec = (node*) malloc(sizeof(node));
    strcpy(newrec->data , x);
    newrec->next = l->start;
    newrec->prev = NULL;
    if (l->start != NULL)
    {
        l->start->prev = newrec;
    }
    l->start = newrec;
    if (l->end == NULL)
    {
        l->end = newrec;
    }
}

void insertend(LL *l, char *x)
{
    node *newrec = (node*) malloc(sizeof(node));
    strcpy(newrec->data , x);
    newrec->next = NULL;
    newrec->prev = l->end;
    if (l->end != NULL)
    {
        l->end->next = newrec;
    }
    l->end = newrec;
    if (l->start == NULL)
    {
        l->start = newrec;
    }
}

char* delbeg(LL *l)
{
    node *p = l->start;
    if (p == NULL)
    {
        printf("LL empty\n");
        return NULL;
    }
    
    l->start = l->start->next;
    char *d = strdup(p->data);
    free(p);
    return d;
}

char* delend(LL *l)
{
    node *p = l->end;
    if (p == NULL)
    {
        printf("LL empty\n");
        return NULL;
    }
    
    if (l->start == l->end)
    {
        l->start = l->end = NULL;
    }
    else
    {
        l->end = l->end->prev;
        l->end->next = NULL;
    }
    char *d = strdup(p->data);
    free(p);
    return d;
}

void menu()
{
    printf("Menu\n");
    printf("\t1. Insert 1\n");
    printf("\t3. Insert 2\n");
    printf("\t4. Delete 1\n");
    printf("\t6. Delete 2\n");
    printf("\t7. count \n");
    printf("\t8. Dispay\n");
    printf("\t11. Exit\n");
    printf("Enter ur choice : ");
}

void display(LL *l)
{
    if (l->start == NULL)
    {
        printf("Empty LL\n\n");
    }
    else
    {
        node *p = l->start;
        while (p != NULL)
        {
            printf(" %s", p->data);
            p = p->next;
        }
    }
    printf("\n\n");
}

int main()
{
    LL *l = (LL*) malloc(sizeof(LL));
    l->start = NULL;
    l->end = NULL;

    while (1){
        menu();
        int choice=0, c;
        char x[100], *y;
        scanf("%d", &choice);
        while ( getchar() != '\n');

        switch (choice)
        {
            case 1:
                printf("Enter : ");
                fgets(x, sizeof(x), stdin);
                x[strcspn(x, "\n")] = '\0';

                insertbeg(l, x);
                printf("Done.\n\n");
                break;

            case 2:
                printf("Enter : ");
                fgets(x, sizeof(x), stdin);
                x[strcspn(x, "\n")] = '\0';

                insertend(l, x);
                printf("Done.\n\n");
                break;

            case 4:
                y = delbeg(l);
                printf("Done: %s.\n\n", y);
                free(y);
                break;

            case 5:
                y = delend(l);
                printf("Done: %s.\n\n", y);
                free(y);
                break;
                
            case 7:
                c = count(l);
                printf("\t\t%d\n", c);
                break;
            
            case 8:
                display(l);
                break;

            case 11:
                printf("Exiting...\n");
                exit(1);

            default:
                printf("Invalid Input.\n");
        }
    }
}