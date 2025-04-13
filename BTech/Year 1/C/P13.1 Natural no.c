#include<stdio.h>

/************************************************************
		WAP TO GENERATE AND DISPLAY FIRST N NATURAL NUMBERS
=============================================================

************************************************************/

int main()
{
	int n,i;
	printf("Enter no of Natural Numbers to display :: ");
	scanf("%d",&n);
	printf("\n");
	for ( i=1 ; i<=n ; i++ )
	{
		printf( "\t%d",i );
	}
	
	getch();
}

