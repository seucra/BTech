#include<stdio.h>
#include<conio.h>
#include<math.h>

void main()
{
	double deg,rad;
	clrscr();
	printf("Enter Angles a in Degres :: ");
	scanf("%lf",&deg);
	printf("%lf",deg);
	rad = deg * 3.1428 / 180;
	printf("\nAngle in Radian :: %lf",rad);
	printf("\nSine of angle :: %lf",sin(rad));
	printf("\ncosine of angle :: %lf",cos(rad));
	printf("\ntan of angle :: %lf",tan(rad));
	getch();
}