#include<stdio.h>

/************************************************************
		WAP TO DISPLAY all even no till nth natural no.
=============================================================

************************************************************/

int main()
{
	int n,i;
	printf("Enter no of Natural Numbers to display :: ");
	scanf("%d",&n);
	printf("\n");
	for ( i=2 ; i<=n ; i+=2 )
	{
		printf( "\t%d",i );
	}
	
	getch();
}

