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
	float a,b;
	printf("\n\t\t\t\tMENU\n\t1.Addition\n\t2.Substraction\n\t3.Multiplication\n\t4.Division\n\nEnter your choise :: ");
	scanf("%d",&cv);
	if (cv<=4 && cv>=1)
	{
		printf("\nEnter 2 integers to perform selected operation :: ");
		scanf("%f%f",&a,&b);
	}
	else
	{
		printf("\t:Wrong Input:");
	}
	switch(cv) //control variable
	{
		case 1 :
				printf("\n\t:Result = %f:\n",a+b) ; 
				//break;
		case 2 : 
				printf("\n\t:Result = %f:\n",a-b) ;
				//break;
		case 3 : 
				printf("\n\t:Result = %f:\n",a*b) ; 
				//break;
		case 4 : 
				printf("\n\t:Result = %f:\n",a/b) ; 
				//break;
		default : printf("\n\t:Thank You for using the Program\n\t\t\t\t\t\t\t-credit to :SHAMS TABREZ AHMED:");
	}
}
