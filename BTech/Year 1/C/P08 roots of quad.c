#include<stdio.h>
#include<conio.h>
#include<math.h>

/**********************************************************************************
							ROOTS OF QUADRATIC EQN
==================================================================================
				WAP to calc roots of quadratic equation
==================================================================================
								ax2+bx+c=0

**********************************************************************************/

void main()
{
	float a,b,c,d,x,y;
	printf("\nQuadratic Eqn :: ax2 + bx + c = 0");
	printf("\nEnter value of a , b and c  :: ");
	scanf("%f%f%f",&a,&b,&c);
	d = b*b - 4*a*c;
	
	if (d == 0)
	{
		//Real and Equal Roots
		printf("\n\tRoots are Real and Equal");
		x = y = -(b)/(2*a);
		printf("\n\t\tRoots are :: %f ; %f" , x, y);
	}
		else if (d>0)
		{
			//Real Roots
			printf("\n\tRoots are Real");
			x = (-(b) + sqrt(d))/(2*a);
			y = (-(b) - sqrt(d))/(2*a);
			printf("\n\t\tRoots are :: %f ; %f" , x, y);
		}
			else 
			{
				//Imaginary Roots
				printf("\n\tRoots are Imaginary!!!");
				printf("\n\t\tRoots are :: ");
				x = + (sqrt(-(d))/(2*a));
				y = - (sqrt(-(d))/(2*a));
				printf("%f + i [%f] " , -(b) , x);
				printf("; %f + i [%f]" , -(b) , y);
			}
	getch();
}
