#include<stdio.h>

/************************************************************
WAP TO CALC summ of series : 1 + 1/3 + 1/5 + 1/7 +++ n terms 
=============================================================

************************************************************/

int main()
{
	int n,i,d=1;
	float m=0;
	printf("Enter no of terms of series :: ");
	scanf("%d",&n);
	printf("\n");
	for ( i=0 ; i<n ; i++ )
	{
		m+=1.0/d;
		d+=2;
	}
	printf( "\tSum of %d terms in series is :: %f",n,m );
	getch();
}
