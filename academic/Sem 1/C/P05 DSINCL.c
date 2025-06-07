#include<stdio.h>
#include<conio.h>
#include<math.h>

void main()
{
	float x1,x2,y1,y2,d,s,inc;
	clrscr();
	printf("\nEnter coordinates of point A :: ");
	scanf("%f%f",&x1,&y1);
	printf("\nEnter coordinates of point B :: ");
	scanf("%f%f",&x2,&y2);
	d = sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1) ); //distance of points
	s = (y2-y1) / (x2-x1);	//slope
	inc = atan(s);
	inc = inc * 180 / 3.1415;
	printf("\n\nDistance :: %lf\nSlope :: %lf\nInclination :: %lf",d,s,inc);
	getch();
}