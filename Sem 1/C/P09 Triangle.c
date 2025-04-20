#include<stdio.h>
#include<conio.h>

/**********************************************************************************
							ROOTS OF QUADRATIC EQN
==================================================================================
				WAP to Identify Triangle
==================================================================================
								ax2+bx+c=0

**********************************************************************************/

void main()
{
	float a,b,c;
	printf("\t\t\t\tWELCOME TO THE PROGRAM!!!");
	while (1)
	{
		printf("\nEnter Sides of triangle :: ");
		scanf("%f%f%f",&a,&b,&c);
		if (a==0 && b==0 && c==0)
		{
			printf("EXITING THE PROGRAM...");
			break;
		}
		if ( ( a+b>c ) && ( b+c>a ) && ( a+c>b ))
		{
			printf("\n\t:Valid Triangle:");
			if ( a==b && b==c )
			{
				printf("\n\t\t:Equilateral Triangle:\n\n");
			}
		
			else if ( a==b || b==c || a==c )
			{
				printf("\n\t\t:Isosceles Triangle:\n\n");
			}
			else 
			{
				printf("\n\t\t:Scalene Triangle:\n\n");
			}
		}
		else
		{
			printf("\n\t:Invalid Triangle:\n\n");
		}
	}
	getch();
}
