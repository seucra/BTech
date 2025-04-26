#include <stdio.h>
#include <stdlib.h>

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

void insertbeg(LL *l, char x)
{
    node *newrec = (node*) malloc(sizeof(node));
    newrec->data = x;
    newrec->next = l->start;
    l->start->prev = newrec;
    newrec->prev = NULL;
    l->start = newrec;
}

void insertend(LL *l, char x)
{
    node *newrec = (node*) malloc(sizeof(node));
    newrec->data = x;
    newrec->next = NULL;
    newrec->prev = l->end;
    l->end->next = newrec;
    l->end = newrec;
}

char delbeg(LL *l)
{
    node *p = l->start;
    if (p == NULL)
    {
        printf("LL empty\n");
        return -1;
    }
    
    l->start = l->start->next;
    char *d = p->data;
    free(p);
    return d;
}

char delend(LL *l)
{
    
}