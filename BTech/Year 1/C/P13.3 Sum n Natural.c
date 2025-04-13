#include<stdio.h>

/************************************************************
		WAP TO CALC summ of first n natural using FOR loop
=============================================================

************************************************************/

int main()
{
	int n,i,m;
	printf("Enter no of Natural Numbers to ADD :: ");
	scanf("%d",&n);
	printf("\n");
	m=0;
	for ( i=1 ; i<=n ; i++ )
	{
		m+=i;
	}
	printf( "\tSum of first %d Natural No. is :: %d",n,m );
	getch();
}

