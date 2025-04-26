#include <stdio.h>
#include <stdlib.h>


typedef struct node
{
    int data;
    struct node *next;    
}node;

typedef struct LL
{
    node *start;
}LL;

void insertend(LL *l, int x)
{
    node *newrec = (node*) malloc(sizeof(node));
    newrec->data = x;
    newrec->next = NULL;

    if (l->start == NULL)
    {
        l->start = newrec;
    }
    else
    {
        node *p = l->start;
        while (p->next != NULL)
        {
            p = p->next;
        }
        p->next = newrec;
    }
}

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
            printf(" %d", p->data);
            p = p->next;
        }
    }
    printf("\n\n");
}

void menu()
{
    printf("Menu\n");
    printf("\t1. Insert 1\n");
    printf("\t2. Insert 2\n");
    printf("\t3. Insert 3\n");
    printf("\t4. Delete 1\n");
    printf("\t5. Delete 2\n");
    printf("\t6. Delete 3\n");
    printf("\t7. count \n");
    printf("\t8. Dispay\n");
    printf("\t9. search\n");
    printf("\t10. reverse\n");
    printf("\t11. Exit\n");
    printf("Enter ur choice : ");
}

int main()
{
    LL *l = (LL*) malloc(sizeof(LL));

    while (1){
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
                
                break;
            case 2:
                printf("Enter : ");
                scanf("%d", &x);
                while ( getchar() != '\n');
                insertend(l, x);
                printf("Done.\n\n");
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                x = count(l);
                printf("\t\t%d\n", x);
                break;
            case 8:
                display(l);
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                printf("EXiting...\n");
                exit(1);
            default:
                printf("Invalid Input.\n");
        }
    }
}