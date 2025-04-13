#include<stdio.h>

/************************************************************
WAP TO CALC summ of series : 1 - 1/3 + 1/5 - 1/7 +-+ n terms 
=============================================================

************************************************************/

int main()
{
	int n,i;
	float m=0;
	printf("Enter no of terms of series :: ");
	scanf("%d",&n);
	printf("\n");
	for ( i=0 ; i<n ; i++ )
	{
		if (i%2==0)
		{
			m+=1.0/(2*i+1);
		}
		else 
		{
			m-=1.0/(2*i+1);
		}
	}
	printf( "\tSum of %d terms in series is :: %f",n,m );
	getch();
}
