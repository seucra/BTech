// Stack: Paranthesis Correction

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define N 20

typedef struct stack
{
    char a[N];
    int top;
}stack;

void push(stack *s, char x)
{
    s->a[s->top++] = x;
}

char pop(stack *s)
{
    return s->a[--s->top];
}

int isempty(stack *s)
{
    return (s->top == -1);
}

int isopenb(char x)
{
    return (x=='(' || x=='[' || x=='{');
}

int iscloseb(char x)
{
    return (x==')' || x==']' || x=='}');
}

int check(char c[])
{
    int i;
    char x, e;
    stack *s = malloc(sizeof(stack));
    s->top = -1;

    for (i=0; i<strlen(c); i++)
    {
        x = c[i];
        if (isopenb(x))
        {
            push(s, x);
        }
        if (iscloseb(x))
        {
            if (isempty(s))
            {
                return 0;
            }
            else 
            {
                e = pop(s);
                if (iscloseb(x) && !isopenb(e))
                {
                    return 0;;
                }
            }
        }
    }
    if(isempty(s))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int main()
{
    char s[20];
    printf("Enter Exp : ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';
    if (check(s))
    {
        printf("Valid Exp\n");
    }
    else
    {
        printf("Valid Exp\n");
    }
    exit(1);
}