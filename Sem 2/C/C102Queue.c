// Queue

#include <stdio.h>
#include <stdlib.h>
#define N 30

typedef struct  queue{
    int a[N];
    int front, rear;
    int count;
}queue;

void enqueue(queue *q, int x)
{
    if (q->count == N)
    {
        printf("\nQueue Overflow\n");
    }
    else
    {
        q->count++;
        q->rear = (q->rear+1) %N;
        q->a[q->rear] = x;
    }
}

int isempty(queue *q)
{
    return (q->count ==0);
}

int dequeue(queue *q)
{
    if (isempty(q))
    {
        return -1;
    }
    q->count--;
    int x = q->a[q->front];
    q->front = (q->front+1 ) % N;
    return x;
}

void display(queue *q)
{
    if (isempty(q)){
        printf("\nQueue Empty\n");
    }
    else
    {
        int i=q->front;
        printf("Queue ->\n");
        while (i != (q->rear + 1) % N)
        {
            printf("\t%d", q->a[i]);
            i= (i+1)%N;
        }
    }
    printf("\n");
}

int main()
{
    int ch, x;
    queue *q = malloc(sizeof(queue));
    q->front =  q->count = 0;
    q->rear = -1;
    while (1)
    {
        printf("\n1. Enqueue\n2. Dequeue\n3. Display Queue\n4. Exit\n\tChoice: ");
        scanf("%d", &ch);
        if (ch==4)
        {
            break;
        }
        switch (ch)
        {
        case 1:
            printf("Enter Ele : ");
            scanf("%d", &x);
            enqueue(q, x);
            break;
        case 2:
            x = dequeue(q);
            if (x==-1)
            {
                printf("Underflow\n");
            }
            else
            {
                printf("\t\t%d", x);
            }
            break;
        case 3:
            display(q);
            break;
        default:
            printf("Invalid Ch\n");
            break;
        }
    }
    free(q);
}