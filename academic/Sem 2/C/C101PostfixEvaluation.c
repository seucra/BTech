// Stack: Evaluation

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define N 40

typedef struct stack
{
    int a[N]; // store integers, not chars
    int top;
} stack;

void push(stack *s, int x)
{
    s->a[s->top++] = x;
}

int pop(stack *s)
{
    return s->a[--s->top];
}

int peek(stack *s)
{
    return s->a[s->top - 1];
}

int isoperator(char x)
{
    return (x == '+' || x == '-' || x == '*' || x == '/');
}

int isoperand(char x)
{
    return (x >= '0' && x <= '9'); // Check for numeric characters
}

int priority(char x)
{
    if (x == '*' || x == '/')
    {
        return 2;
    }
    else
    {
        return (x == '+' || x == '-');
    }
}

void convert(char infix[], char postfix[])
{
    int i, k = 0;
    char x, e;
    stack *s = malloc(sizeof(stack));
    s->top = 0;

    for (i = 0; i < strlen(infix); i++)
    {
        x = infix[i];
        if (isoperand(x))
        {
            postfix[k++] = x;
        }
        else if (isoperator(x))
        {
            while (s->top > 0 && priority(x) <= priority(peek(s)))
            {
                e = pop(s);
                postfix[k++] = e;
            }
            push(s, x);
        }
        else if (x == '(')
        {
            push(s, x);
        }
        else if (x == ')')
        {
            while (peek(s) != '(')
            {
                e = pop(s);
                postfix[k++] = e;
            }
            pop(s); // Remove '('
        }
    }

    while (s->top > 0)
    {
        e = pop(s);
        postfix[k++] = e;
    }

    postfix[k] = '\0';
    free(s); // Free memory after usage
}

int operate(int a, int b, char x)
{
    if (x == '+')
    {
        return a + b;
    }
    else if (x == '-')
    {
        return a - b;
    }
    else if (x == '*')
    {
        return a * b;
    }
    else if (x == '/')
    {
        return a / b;
    }
    return 0;
}

int eval(char postfix[])
{
    int i;
    char x;
    int a, b;
    stack *s = malloc(sizeof(stack));
    s->top = 0;

    for (i = 0; i < strlen(postfix); i++)
    {
        x = postfix[i];
        if (isoperand(x))
        {
            push(s, x - '0'); // Convert character to integer before pushing
        }
        else if (isoperator(x))
        {
            b = pop(s);
            a = pop(s);
            push(s, operate(a, b, x));
        }
    }

    int result = pop(s);
    free(s); // Free memory after usage
    return result;
}

int main()
{
    char infix[40], postfix[40];
    printf("Enter Infix: ");
    fgets(infix, sizeof(infix), stdin);
    infix[strcspn(infix, "\n")] = '\0';

    convert(infix, postfix);
    printf("\nPostfix: %s", postfix);

    int result = eval(postfix);
    printf("\nResult: %d", result);

    return 0;
}
