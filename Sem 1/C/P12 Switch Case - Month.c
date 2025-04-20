#include<stdio.h>

/************************************************************
Take Month no and Display Corresponding Month Name
=============================================================
	switch(cv) //control variable
	{
		case cc : op1 ; //case constant , option1
				break;
		case cc : op2 ; //case constant , option2
				break;
		default : opn ; //deafault , option n
				break;
************************************************************/

int main()
{
	int cv;
	printf("Enter no. of Month :: ");
	scanf("%d",&cv);
	switch(cv) //control variable
	{
		case 1 : printf("\t\t:January:") ; 
				break;
		case 2 : printf("\t\t:February:") ;
				break;
		case 3 : printf("\t\t:March:") ; 
				break;
		case 4 : printf("\t\t:April:") ; 
				break;
		case 5 : printf("\t\t:May:") ; 
				break;
		case 6 : printf("\t\t:June:") ; 
				break;
		case 7 : printf("\t\t:July:") ; 
				break;
		case 8 : printf("\t\t:August:") ; 
				break;
		case 9 : printf("\t\t:September:") ; 
				break;
		case 10 : printf("\t\t:October:") ; 
				break;
		case 11 : printf("\t\t:November:") ; 
				break;
		case 12 : printf("\t\t:December:") ; 
				break;
		default : printf("\t:Wrong Input:");
				
	}
}
