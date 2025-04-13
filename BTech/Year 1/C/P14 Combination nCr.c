#include<stdio.h>

/************************************************************
			WAP TO CALC Factorial of N
=============================================================

************************************************************/
int fac(int a)
{
	int i,f=1;
	for ( i=1 ; i<=a ; i++ )
	{
		f*=i;
	}
	return f;
}

int main()
{
	int n,r,d;
	float res;
	printf("Enter n and r of nCr :: ");
	scanf("%d%d",&n,&r);
	printf("\n");
	res = fac(n)/(fac(r)*fac(n-r));
	printf( "\t:: Result = %f ::",res );
	getch();
}
