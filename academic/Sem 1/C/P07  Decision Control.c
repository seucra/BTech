#include<stdio.h>

/**********************************************************************************
								DESION CONTROL
==================================================================================
WAP (simple) to display Student Grade Based on Marks
==================================================================================
			M		|	G
			80+		|	O
			70-90	|	A
			60-69	|	B
			50-59	|	C
			<50		|	E
**********************************************************************************/
void main()
{
	int mar;
	printf("Enter any number for comparision :: ");
	scanf("%d",&mar);
	if (mar>100)
	{
		printf("\nWrong Input");
	}
	else if (mar>=80)
	{
		printf("\nYou Have Achived Grade :: O");
	}
	else if (mar>=70) 
	{
		printf("\nYou Have Achived Grade :: A");
	}
	else if (mar>=60) 
	{
		printf("\nYou Have Achived Grade :: B");
	}
	else if (mar>=50)
	{
		printf("\nYou Have Achived Grade :: C");
	}
	else 
	{
		printf("\nYou Have Achived Grade :: E");
	}
	getch();
}
