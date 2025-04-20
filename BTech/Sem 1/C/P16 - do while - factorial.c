#include<stdio.h>

/************************************************************
			WAP TO CALC Factorial of N
=============================================================

************************************************************/

int main()
{
	int n,i,f=1;
	do
	{
		printf("Enter no to calc factorial of :: ");
		scanf("%d",&n);
	}
	while (n < 0);
	for ( i=1 ; i<=n ; i++ )
	{
		f*=i;
	}
	printf( "\tFactorial of %d is :: %d",n,f );
	getch();
}
