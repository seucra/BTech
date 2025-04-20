#include <stdio.h>

/************************************************************
=============================================================
************************************************************/

//a function aside from main to calculate factorial

int fact(int a)
{
    int j = 1;
    for (int i = 1; i <= a; i++)
    {
        j *= i;
    }
    return j;
}

// main function

int main() 
{
    int a;
    printf("Enter number: ");
    scanf("%d", &a);

    for (int i = 1; i <= a; i++) 
    {
        printf("%d! = %d\n", i, fact(i));
    }
    
    return 0;  
}

