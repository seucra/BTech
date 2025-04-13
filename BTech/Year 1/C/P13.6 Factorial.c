#include<stdio.h>

/************************************************************
			WAP TO CALC Factorial of N
=============================================================

************************************************************/

int main()
{
	int n,i,f=1;
	printf("Enter no to calc factorial of :: ");
	scanf("%d",&n);
	for ( i=1 ; i<=n ; i++ )
	{
		f*=i;
	}
	printf( "\tFactorial of %d is :: %d",n,f );
	getch();
}
