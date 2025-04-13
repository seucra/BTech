#include<stdio.h>

/************************************************************
		WAP TO DISPLAY all odd no till nth natural no.
=============================================================

************************************************************/

int main()
{
	int n,i;
	printf("Enter end Natural Numbers :: ");
	scanf("%d",&n);
	printf("\n");
	for ( i=1 ; i<=n ; i+=2 )
	{
		printf( "\t%d",i );
	}
	
	getch();
}

