// Infix to postfix

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

char peek(stack *s)
{
    return s->a[s->top -1];
}

int isoperator(char x)
{
    return (x=='+' || x=='-' || x=='*' || x== '/');
}

int isoperand(char x)
{
    return ((x>='a' && x<='Z') || (x>='a' && x<='z'));
}

int priority(char x)
{
    if (x=='*' || x=='/')
    {
        return 2;
    }
    else
    {
        return (x=='+' || x=='-');
    }
}

void convert(char infix[], char postfix[])
{
    int i, k=0;
    char x, e;
    stack *s = malloc(sizeof(stack));
    s->top = -1;

    for (i=0; i<strlen(infix); i++)
    {
        x = infix[i];
        if (isoperand(x))
        {
            postfix[k++] = x;
        }
        else if (isoperator(x))
        {
            while (priority(x) <= priority(peek(s)))
            {
                e = pop(s);
                postfix[k++] = e;
            }
            push(s, x);
        }
        else if (x=='(')
        {
            push(s, x);
        }
        else // x== ')'
        {
            while (peek(s) != ')')
            {
                e = pop(s);
                postfix[k++] = e;
            }
            pop(s);
        }
    }
    postfix[k] = '\0';
}

int main()
{
    char infix[40], postfix[40];
    printf("Enter Infix : ");
    fgets(infix, sizeof(infix), stdin);
    infix[strcspn(infix, "\n")] = '\0';
    convert(infix, postfix);
    printf("\nPostfix : %s", postfix);
    exit(1);
}