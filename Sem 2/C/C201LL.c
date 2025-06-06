// Linked List: Singly Implementation

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

void insertbeg(LL *l, int x)
{
    node *newrec = (node*) malloc(sizeof(node));
    newrec->data = x;
    newrec->next = l->start;
    l->start = newrec;
}

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

int insertpos(LL *l, int x, int ps)
{
    int i=1;
    node *p, *newrec = malloc(sizeof(node));
    newrec->data = x;

    int c = count(l);
    if (ps > c)
    {
        printf("Invalid Position.\n");
        return 0;
    }

    p = l->start;
    while (i<=ps)
    {
        i++;
        p = p->next;
    }
    newrec->next = p->next;
    p->next = newrec;
    return 1;
}

int delbeg(LL *l)
{
    node *p = l->start;
    if (p == NULL)
    {
        printf("LL empty\n");
        return -1;
    }
    
    l->start = l->start->next;
    int d = p->data;
    free(p);
    return d;
}

int delend(LL *l)
{
    if (l->start == NULL)
    {
        printf("LL empty\n");
        return -1;
    }
    node *p = l->start;
    int d;
    if (p->next == NULL)
    {
        d = p->data;
        l->start = NULL;
        free(p);
        return d;
    }
    while (p->next->next != NULL)
    {
        p = p->next;
    }
    node *q = p->next;
    d = q->data;
    p->next = NULL;
    free(q);
    return d;
}

int delpos(LL *l, int ps)
{
    int c = count(l);
    if (ps > c)
    {
        printf("Invalid Position.\n");
        return 0;
    }

    int i=1, d;
    node *q, *p = l->start;
    while (i<ps)
    {
        i++;
        p = p->next;
    }
    q = p->next;
    d = q->data;
    p->next = q->next;
    free(q);
    return d;
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

int search(LL *l, int x)
{
    int c=0;
    node *p = l->start;
    while (p != NULL)
    {
        if (x == p->data)
        {
            c++;
        }
        p = p->next;
    }
    return c;
}

void reverse(LL *l)
{
    LL k, *o = l;
    node *p = l->start;
    k.start = NULL;

    while (p != NULL)
    {
        insertbeg(&k, p->data);
        p = p->next;
    }
    l->start = k.start;
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
        int choice=0, x=0, p=0;
        scanf("%d", &choice);
        while ( getchar() != '\n');

        switch (choice)
        {
            case 1:
                printf("Enter : ");
                scanf("%d", &x);
                while ( getchar() != '\n');

                insertbeg(l, x);
                printf("Done.\n\n");
                break;

            case 2:
                printf("Enter : ");
                scanf("%d", &x);
                while ( getchar() != '\n');

                insertend(l, x);
                printf("Done.\n\n");
                break;

            case 3:
                printf("Enter E&pos: ");
                scanf("%d", &x);
                while ( getchar() != '\n');
                scanf("%d", &p);
                while ( getchar() != '\n');

                insertpos(l, x, p);
                printf("Done.\n\n");
                break;

            case 4:
                x = delbeg(l);
                printf("Done: %d.\n\n", x);
                break;

            case 5:
                x = delend(l);
                printf("Done: %d.\n\n", x);
                break;

            case 6:
                printf("Enter pos: ");
                scanf("%d", &x);
                while ( getchar() != '\n');

                x = delpos(l, x);
                printf("Done: %d.\n\n", x);
                break;

            case 7:
                x = count(l);
                printf("\t\t%d\n", x);
                break;

            case 8:
                display(l);
                break;

            case 9:
                printf("Enter E: ");
                scanf("%d", &x);
                while ( getchar() != '\n');

                x = search(l, x);
                printf("Element found times : %d\n", x);
                break;

            case 10:
                reverse(l);

                printf("Reversed :\t");
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